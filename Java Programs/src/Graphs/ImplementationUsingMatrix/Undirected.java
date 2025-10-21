package Graphs.ImplementationUsingMatrix;
// time-complexity = O(V^2), V -> Vertices
// space-complexity = O(V^2), V -> Vertices
public class Undirected {
    private int[][] adjMatrix;
    private int numVertices;

    // constructor to initialize
    public Undirected(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // adding an edge
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    // for undirected-weighted-graph
    public void addEdgeWeighted(int i, int j, int weight) {
        adjMatrix[i][j] = weight;
        adjMatrix[j][i] = weight;
    }

    // removing an edge
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    // print adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix (Unweighted Undirected Graph):");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
