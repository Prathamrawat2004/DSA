package Graphs.ImplementationUsingList;

import java.util.ArrayList;
import java.util.List;

// space-complexity: O(V + E) 
public class DirectedWeighted {
    class Edge {
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
    public DirectedWeighted(int numVertices) {
        this.numVertices1 = numVertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // add edge (directed)
    public void addEdge(int from, int to, int weight) {
        adjList.get(from).add(new Edge(to, weight));
    }

    // remove edge
    public void removeEdge(int from, int to) {
        // only remove edge from 'from' → 'to'
        adjList.get(from).removeIf(edge -> edge.to == to);
    }

    // print adjacency list
    public void printGraph() {
        System.out.println("Adjacency List (Directed Weighted Graph):");
        for (int i = 0; i < numVertices1; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("(" + edge.to + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}
