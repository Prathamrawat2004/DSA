package Graphs.ImplementationUsingList;

import java.util.ArrayList;
import java.util.List;

// space-complexity: O(V + E) 
public class UndirectedWeighted {
    public class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private int numVertices1;
    private List<List<Edge>> adjList;

    // constructor
    public UndirectedWeighted(int numVertices) {
        this.numVertices1 = numVertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // add edge
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Edge(v, weight));
        adjList.get(v).add(new Edge(u, weight)); // both directions
    }

    // remove edge
    public void removeEdge(int u, int v) {
        // remove edge from u → v
        adjList.get(u).removeIf(edge -> edge.to == v);

        // remove edge from v → u
        adjList.get(v).removeIf(edge -> edge.to == u);
    }

    // print adjacency list
    public void printGraph() {
        System.out.println("Adjacency List (Undirected Weighted Graph):");
        for (int i = 0; i < numVertices1; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("(" + edge.to + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

}
