/* Vertical Traversal of Binary Tree */

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Day47 {
    // Helper class to store the node and its horizontal distance
    private static class NodeHD {
        Node node;
        int horizontalDistance;

        NodeHD(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // Create a map to store nodes in each vertical line
        Map<Integer, ArrayList<Integer>> verticalLines = new TreeMap<>();

        // Create a queue to perform level order traversal
        Queue<NodeHD> queue = new LinkedList<>();
        queue.offer(new NodeHD(root, 0)); // Enqueue root with horizontal distance 0

        // Perform level order traversal
        while (!queue.isEmpty()) {
            NodeHD current = queue.poll();
            Node currentNode = current.node;
            int currentHorizontalDistance = current.horizontalDistance;

            // Add current node's value to the corresponding vertical line
            if (!verticalLines.containsKey(currentHorizontalDistance)) {
                verticalLines.put(currentHorizontalDistance, new ArrayList<>());
            }
            verticalLines.get(currentHorizontalDistance).add(currentNode.data);

            // Enqueue the left and right children with updated horizontal distance
            if (currentNode.left != null) {
                queue.offer(new NodeHD(currentNode.left, currentHorizontalDistance - 1));
            }
            if (currentNode.right != null) {
                queue.offer(new NodeHD(currentNode.right, currentHorizontalDistance + 1));
            }
        }

        // Traverse the vertical lines in order and add the nodes to the result
        for (int key : verticalLines.keySet()) {
            ArrayList<Integer> lineNodes = verticalLines.get(key);
            result.addAll(lineNodes);
        }

        return result;
    }

  
    public static void main(String[] args) {
        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> verticalTraversal = verticalOrder(root);
        System.out.println(verticalTraversal);
    }
}

