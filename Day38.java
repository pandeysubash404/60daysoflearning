/*   Diameter of a Binary Tree */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    int diameter(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        // Calculate the maximum diameter
        int maxDiameter = Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));

        return maxDiameter;
    }

    int height(Node node) {
        if (node == null)
            return 0;

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Return the maximum height between the left and right subtrees
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
public class Day38{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int diameter = tree.diameter(tree.root);
        System.out.println("Diameter of the binary tree: " + diameter);
    }
}
