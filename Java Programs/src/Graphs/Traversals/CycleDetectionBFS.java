package Graphs.Traversals;
// UNDIRECTED GRAPH
// time-complexity - O(V + E)
// space-complexity - O(V)
import java.util.*;

public class CycleDetectionBFS {
    private int numVertices1;
    private List<List<Integer>> adjList;

    // constructor
    public CycleDetectionBFS(int numVertices) {
        this.numVertices1 = numVertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices1; i++) {
            adjList.add(new ArrayList<>());
        }

    }

    // cycle detection
    private boolean bfs(int start, boolean[] visited) {
        // using a queue to store the neighbour
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(new int[] { start, -1 }); // node + parent

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int neighbour : adjList.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(new int[] { neighbour, node });
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[numVertices1];

        for (int i = 0; i < numVertices1; i++) {
            if (!visited[i]) {
                if (bfs(i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
