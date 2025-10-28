package Graphs;

import java.util.*;

// Tarjan's Algorithm for Bridges
// Undirected Graph
public class BridgeInGraph {
    private int numVertices1;
    private List<List<Integer>> adjList;

    private int time = 0; // discovery time counter

    public BridgeInGraph(int numVertices) {
        this.numVertices1 = numVertices;

        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // dfs to find bridges
    private void dfs(int node, int parent, boolean[] visited, int[] disc, int[] low) {
        visited[node] = true;
        disc[node] = low[node] = ++time;

        for (int neighbour : adjList.get(node)) {
            // skip the parent
            if (neighbour == parent) {
                continue;
            }

            if (!visited[neighbour]) {
                dfs(neighbour, node, visited, disc, low);

                // after return or retracing, check if the edge (node, neighbour) is a bridge or
                // not
                low[node] = Math.min(low[node], low[neighbour]);

                // bridge condition
                if (disc[node] < low[neighbour]) {
                    System.out.println("Bridge Found!");
                }

            } else {
                // cycle backedge case
                // retracing when cycle is found
                // when the cycle is found, the current edge is not considered bridge
                low[node] = Math.min(low[node], disc[neighbour]);
            }
        }
    }

    public void findBridges() {
        boolean[] visited = new boolean[numVertices1];
        int[] disc = new int[numVertices1];
        int[] low = new int[numVertices1];

        for (int i = 0; i < numVertices1; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low);
            }
        }
    }

}
