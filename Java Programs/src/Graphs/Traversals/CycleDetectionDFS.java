package Graphs.Traversals;
// UNDIRECTED GRAPH
import java.util.*;

public class CycleDetectionDFS {
    private int numVertices1;
    private List<List<Integer>> adjList;

    // constructor
    public CycleDetectionDFS(int numVertices) {
        this.numVertices1 = numVertices;

        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // cycle detection code using dfs
    // the dfs only traverses to the connected nodes hence diconnected nodes might
    // not get traversed
    // time-complexity - O(V + E)
    // space-complexity - O(V)
    private boolean dfs(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, parent)) {
                    return true;
                }
            } else if (neighbour != parent) {
                // visited and not parent => cycle found
                return true;
            }
        }

        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[numVertices1];

        // traversing all nodes
        for (int i = 0; i < numVertices1; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

}
