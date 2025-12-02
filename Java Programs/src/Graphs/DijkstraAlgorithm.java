package Graphs;

import java.util.*;

public class DijkstraAlgorithm {
    public static class Pair {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // method-1
    // main idea: minimum distances from source to each node
    public static int[] dijkstra(int V, List<List<Pair>> adj, int source) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        // initial distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0; // as source -> source

        // total iterations to perform
        for (int i = 0; i < V - 1; i++) {
            // find the unvisited node with smallest distance
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (int v = 0; v < V; v++) {
                if (!visited[v] && dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }

            if (u == -1) {
                break; // no reachable nodes left
            }

            // mark the current node as visited
            visited[u] = true;

            // relax the edges
            for (Pair neighbour : adj.get(u)) {
                int v = neighbour.node;
                int weight = neighbour.weight;

                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        return dist;
    }

    // method-2
    public static int[] dijkstra2(int V, List<List<Pair>> adj, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // implementing priority-queue to extract minimum distance node
        // by default it prioritizes smallest element first but only if the data
        // stucutre is 'int'
        // here, it's a custom class so we need to specify how we want to prioritize
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        dist[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.weight;

            // skip if we already found a better distance
            // as multiple entries for same node might be there with different distances or
            // weights
            if (d > dist[u]) {
                continue;
            }

            // relax neighbours
            for (Pair neighbour : adj.get(u)) {
                int v = neighbour.node;
                int weight = neighbour.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }

        }

        return dist;
    }
}
