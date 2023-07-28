/* Level of Nodes in tree */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Day58 {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        boolean[] visited = new boolean[V]; // To keep track of visited vertices
        int[] level = new int[V]; // To store the level of each vertex
        Queue<Integer> queue = new LinkedList<>();

        visited[0] = true;
        queue.add(0);
        level[0] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            // Explore all adjacent vertices of the current vertex
            for (int neighbor : adj.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    level[neighbor] = level[currentVertex] + 1;
                }
            }
        }

        // Check if node X exists in the graph and return its level
        if (X >= 0 && X < V) {
            return level[X];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // Example graph representation using adjacency list
        int V = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the undirected graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);

        int X = 3; // Node whose level needs to be found

        Day58 graphTraversal = new Day58();
        int levelOfX = graphTraversal.nodeLevel(V, adj, X);
        System.out.println("Level of node " + X + " is: " + levelOfX);
        /*
         Output :
         Level of node 3 is: 2
         */
    }
}

