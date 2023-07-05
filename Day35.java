/* Check for BST */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Day35 {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTUtil(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }

    public static void main(String[] args) {
        // Create a binary tree
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        // Create an instance of the Day35 class
        Day35 solution = new Day35();

        // Check if the binary tree is a BST
        boolean isBST = solution.isBST(root);

        // Print the result
        System.out.println("Is the binary tree a BST? " + isBST);
    }
}
