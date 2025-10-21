package Graphs.Traversals;

import java.util.*;

// time-complexity: O(V + E) (adjacency-list)
// space-complexity: O(V + E) (adjacency-list)
// time-complexity: O(V^2) (adjacency-matrix)
// space-complexity: O(V^2) (adjacency-matrix)
public class DFS {
    private int numVertices1;
    private List<List<Integer>> adjList;

    // constructor
    public DFS(int numVertices) {
        this.numVertices1 = numVertices;

        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // DFS Traversal
    public void dfs(int start) {
        boolean[] visited = new boolean[numVertices1];
        System.out.println("DFS Traversal: ");
        dfsHelper(start, visited);
    }

    // definition of helper function
    public void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.println(node + " ");

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfsHelper(neighbour, visited);
            }
        }
    }

}
