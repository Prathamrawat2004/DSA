package Graphs;

import java.util.*;

// for DIRECTED ACYCLIC GRAPHS only 
// time-complexity - O(V + E)
// space-complexity - O(V)
public class TopologicalSort {
    private int numVertices1;
    private List<List<Integer>> adjList;

    public TopologicalSort(int numVertices) {
        this.numVertices1 = numVertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // helper function (DFS)
    private void dfs(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, stack);
            }
        }

        // pushing the current node before returning
        stack.push(node);
    }

    // topological sort (DFS)
    public List<Integer> topologicalSort() {
        boolean[] visited = new boolean[numVertices1];
        Stack<Integer> stack = new Stack<>();

        // traversing each node
        for (int i = 0; i < numVertices1; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack); // function to travel to the last node
            }
        }

        // adding elements in a list
        List<Integer> topoOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topoOrder.add(stack.pop());
        }

        return topoOrder;
    }

    // KAHN's ALGORITHM (BFS + INDEGREE)
    public List<Integer> topologicalSort2() {
        // calculating indegree
        int[] inDegree = new int[numVertices1];
        for (int i = 0; i < numVertices1; i++) {
            for (int vertex : adjList.get(i)) {
                inDegree[vertex]++;
            }
        }

        // adding the vertex with '0' indegree to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int j = 0; j < numVertices1; j++) {
            if (inDegree[j] == 0) {
                queue.add(inDegree[j]);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (int neighbour : adjList.get(node)) {
                inDegree[neighbour]--; // decreasing indegree
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }

        }

        // check for cycle (if topoOrder doesn't include all nodes)
        if (topoOrder.size() != numVertices1) {
            throw new RuntimeException("Graph has a cycle! Topological sort not possible.");
        }

        return topoOrder;
    }

}
