package Graphs;

import java.util.*;

// Tarjan's Algorithm for Articulation Points
// Undirected Graph
// Even if there is no bridge, still there would be articulation point 
public class ArticulationPointInGraph {
    private int numVertices1;
    private List<List<Integer>> adjList;

    private int time = 0; // discovery time counter

    // constructor
    public ArticulationPointInGraph(int numVertices) {
        this.numVertices1 = numVertices;

        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // dfs to find the articulation points
    private void dfs(int node, int parent, boolean[] visited, int[] disc, int[] low, boolean[] isArticulation) {
        visited[node] = true;
        disc[node] = low[node] = ++time;

        int neighbourCount = 0; // counting the neighbours

        for (int neighbour : adjList.get(node)) {
            if (neighbour == parent) {
                continue; // skip the parent
            }

            if (!visited[neighbour]) {
                neighbourCount++;
                dfs(neighbour, parent, visited, disc, low, isArticulation);

                // update the low value
                low[node] = Math.min(low[node], low[neighbour]);

                // articulation condition for non-root nodes
                if (parent != -1 && disc[node] <= low[neighbour]) {
                    isArticulation[node] = true;
                }

            } else {
                // cycle found
                low[node] = Math.min(low[node], disc[neighbour]);
            }

        }

        // articulation condition for root node
        // if the root node has more than one neighbours
        if (parent == -1 && neighbourCount > 1) {
            isArticulation[node] = true;
        }
    }

    public void findArticulationPoints() {
        boolean[] visited = new boolean[numVertices1];
        int[] disc = new int[numVertices1];
        int[] low = new int[numVertices1];
        boolean[] isArticulation = new boolean[numVertices1];

        for (int i = 0; i < numVertices1; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low, isArticulation);
            }
        }

        // print articulation points
        for (int i = 0; i < numVertices1; i++) {
            if (isArticulation[i]) {
                System.out.println("Articulation Point: " + i);
            }
        }

    }
}
