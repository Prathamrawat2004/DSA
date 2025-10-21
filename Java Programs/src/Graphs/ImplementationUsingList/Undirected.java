package Graphs.ImplementationUsingList;

import java.util.*;
// space-complexity: O(V + E) 
public class Undirected {
    private int numVertices1;
    private List<List<Integer>> adjList;

    // constructor
    public Undirected(int numVertices) {
        this.numVertices1 = numVertices;

        // initializing list
        adjList = new ArrayList<>();

        // adding inner lists
        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // adding an edge
    public void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    // remove edge
    public void removeEdge(int u, int v) {
        adjList.get(u).remove(Integer.valueOf(v));
        adjList.get(v).remove(Integer.valueOf(u));
    }

    // print adjacency list
    public void printGraph() {
        System.out.println("Adjacency List (Undirected Graph):");
        for (int i = 0; i < numVertices1; i++) {
            System.out.print(i + " -> ");
            for (int node : adjList.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

}
