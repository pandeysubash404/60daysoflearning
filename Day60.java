/* Shortest path in Directed Acyclic Graph  */

import java.util.*;

public class Day60 {

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Step 1: Perform Topological Sorting
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[N];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int distance = edge[2];
            graph.get(from).add(new int[]{to, distance});
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 2: Initialize the shortest distances array
        int[] distanceToSource = new int[N];
        Arrays.fill(distanceToSource, Integer.MAX_VALUE);
        distanceToSource[0] = 0;

        // Step 3: Traverse in topological order and update distances
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int distance = neighbor[1];
                if (distanceToSource[node] != Integer.MAX_VALUE
                        && distanceToSource[node] + distance < distanceToSource[nextNode]) {
                    distanceToSource[nextNode] = distanceToSource[node] + distance;
                }
                if (--indegree[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }

        // Step 4: Handle unreachable vertices
        for (int i = 0; i < N; i++) {
            if (distanceToSource[i] == Integer.MAX_VALUE) {
                distanceToSource[i] = -1;
            }
        }

        return distanceToSource;
    }

    public static void main(String[] args) {
        // Example usage
        int N = 4;
        int M = 5;
        int[][] edges = {
            {0, 1, 3},
            {0, 2, 6},
            {1, 2, 2},
            {1, 3, 4},
            {2, 3, 1}
        };

        Day60 solver = new Day60();
        int[] shortestDistances = solver.shortestPath(N, M, edges);
        System.out.println(Arrays.toString(shortestDistances));
        
        /*
         OutPut :
         [0, 3, 5, 6]
         */
    }
}
