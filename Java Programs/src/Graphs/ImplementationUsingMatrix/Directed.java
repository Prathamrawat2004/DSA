package Graphs.ImplementationUsingMatrix;
// time-complexity = O(V^2), V -> Vertices
// space-complexity = O(V^2), V -> Vertices
public class Directed {
    private int[][] adjMatrix;
    private int numVertices;

    // constructor
    public Directed(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // add an edge (directed)
    public void addEdge(int from, int to) {
        adjMatrix[from][to] = 1; // only one direction
    }

    // for directed-weighted-graph
    public void addEdgeWeighted(int from, int to, int weight) {
        adjMatrix[from][to] = weight; // only one direction
    }

    // remove an edge
    public void removeEdge(int from, int to) {
        adjMatrix[from][to] = 0;
    }

    // print adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix (Directed Unweighted Graph):");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
