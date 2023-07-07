/* Left View of Binary Tree */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean isFirstNode = true;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (isFirstNode) {
                    result.add(current.data);
                    isFirstNode = false;
                }

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }

        return result;
    }
}
public class Day37 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.right = new Node(8);

        ArrayList<Integer> leftView = tree.leftView(tree.root);
        System.out.println("Left view of the binary tree: " + leftView);
    }
}




