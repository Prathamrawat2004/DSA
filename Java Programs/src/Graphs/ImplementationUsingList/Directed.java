package Graphs.ImplementationUsingList;

import java.util.ArrayList;
import java.util.List;

// space-complexity: O(V + E) 
public class Directed {
    private int numVertices1;
    private List<List<Integer>> adjList;

    // constructor
    public Directed(int numVertices) {
        this.numVertices1 = numVertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // add edge (directed)
    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
    }

    // remove edge
    public void removeEdge(int from, int to) {
        adjList.get(from).remove(Integer.valueOf(to));
    }

    // print adjacency list
    public void printGraph() {
        System.out.println("Adjacency List (Directed Graph):");
        for (int i = 0; i < numVertices1; i++) {
            System.out.print(i + " -> ");
            for (int node : adjList.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
