/* k-th smallest element in BST */
public class Day43{
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private int count;
    private int kthSmallest;

    public int KthSmallestElement(Node root, int K) {
        count = 0;
        kthSmallest = -1;

        inorderTraversal(root, K);

        return kthSmallest;
    }

    private void inorderTraversal(Node node, int K) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, K);

        count++;
        if (count == K) {
            kthSmallest = node.data;
            return;
        }

        inorderTraversal(node.right, K);
    }

    public static void main(String[] args) {
        Day43 solution = new Day43();
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        int K = 3;
        int kthSmallestElement = solution.KthSmallestElement(root, K);

        System.out.println("Kth Smallest Element: " + kthSmallestElement);
    }
}
