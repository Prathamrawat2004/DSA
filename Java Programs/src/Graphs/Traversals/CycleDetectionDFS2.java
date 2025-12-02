package Graphs.Traversals;

import java.util.ArrayList;
import java.util.List;

// time-complexity: O(V + E)
// space-complexity: O(V)
public class CycleDetectionDFS2 {
    private int numVertices1;
    private List<List<Integer>> adjList;
    public CycleDetectionDFS2(int numVertices) {
        this.numVertices1 = numVertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // helper function
    private boolean dfs(int node, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true; // for current path

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbour]) {
                // If neighbor is in recursion stack, cycle found
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[numVertices1];
        boolean[] recStack = new boolean[numVertices1];

        for (int i = 0; i < numVertices1; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }
}
