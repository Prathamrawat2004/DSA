package Graphs.Traversals;
import java.util.*;

// time-complexity: O(V + E) (adjacency-list)
// space-complexity: O(V + E) (adjacency-list)
// time-complexity: O(V^2) (adjacency-matrix)
// space-complexity: O(V^2) (adjacency-matrix)

public class BFS{
    private int numVertices1; 
    private List<List<Integer>> adjList;

    // constructor
    public BFS(int numVertices){
        this.numVertices1 = numVertices;

        adjList = new ArrayList<>();
        for(int i = 0; i < numVertices1; i++){
            adjList.add(new ArrayList<>());
        }
    }

    // BFS traversal
    public void bfs(int start){
        boolean[] visited = new boolean[numVertices1];
        Queue<Integer> queue = new LinkedList<>();

        // to start the traversal
        visited[start] = true;
        queue.offer(start);

        System.out.println("BFS Traversal: ");
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node + " ");

            for(int neighbour: adjList.get(node)){
                if(!visited[neighbour]){
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}