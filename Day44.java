package week6;

/* Predecessor and Successor */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Day44 {
    static Node pre = null, suc = null;

    public static void findPreSuc(Node root, int key) {
        findPreSucUtil(root, key);

        // Print the predecessor and successor values
        System.out.println("Predecessor: " + (pre != null ? pre.data : "null"));
        System.out.println("Successor: " + (suc != null ? suc.data : "null"));
    }

    private static void findPreSucUtil(Node root, int key) {
        if (root == null) {
            return;
        }

        // If key is present at root
        if (root.data == key) {
            // Finding predecessor
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                pre = tmp;
            }

            // Finding successor
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                suc = tmp;
            }

            return;
        }

        // If key is smaller than root's data, go to left subtree
        if (key < root.data) {
            suc = root;
            findPreSucUtil(root.left, key);
        }
        // If key is greater than root's data, go to right subtree
        else {
            pre = root;
            findPreSucUtil(root.right, key);
        }
    }

    public static void main(String[] args) {
        /*
                    4
                  /   \
                 2     5
                / \
               1   3
        */
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        int key = 3;
        findPreSuc(root, key);
    }
}
