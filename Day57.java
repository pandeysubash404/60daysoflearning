s/* BFS of graph */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Day57 {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[V]; // To keep track of visited vertices

        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            bfsTraversal.add(currentVertex);

            // Explore all adjacent vertices of the current vertex
            for (int neighbor : adj.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return bfsTraversal;
    }

    public static void main(String[] args) {
        // Example graph representation using adjacency list
        int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the directed graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);
        adj.get(3).add(4);

        Day57 graphTraversal = new Day57();
        ArrayList<Integer> bfsTraversal = graphTraversal.bfsOfGraph(V, adj);
        System.out.println("BFS Traversal from vertex 0: " + bfsTraversal);
        /*
         OutPut :
         BFS Traversal from vertex 0: [0, 1, 2, 3, 4]
         */
    }
}
