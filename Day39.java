
/* Lowest Common Ancestor in a BST */

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BST {
    Node root;

    Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return null;

        // If both n1 and n2 are smaller, LCA lies in the left subtree
        if (root.data > n1 && root.data > n2)
            return LCA(root.left, n1, n2);

        // If both n1 and n2 are greater, LCA lies in the right subtree
        if (root.data < n1 && root.data < n2)
            return LCA(root.right, n1, n2);

        // LCA found
        return root;
    }
}

public class Day39 {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Node(6);
        tree.root.left = new Node(2);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(0);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(9);
        tree.root.left.right.left = new Node(3);
        tree.root.left.right.right = new Node(5);

        int n1 = 2;
        int n2 = 4;
        Node lcaNode = tree.LCA(tree.root, n1, n2);
        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + ": " + lcaNode.data);
    }
}
