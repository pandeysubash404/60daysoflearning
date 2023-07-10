/*  Count Complete Tree Nodes  */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (leftHeight == rightHeight) {
            // The left subtree is a full binary tree
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            // The right subtree is a full binary tree
            return (1 << rightHeight) + countNodes(root.left);
        }
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getHeight(node.left);
    }
}


public class Day40 {
    public static void main(String[] args) {
        // Create a complete binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        Solution solution = new Solution();
        int nodeCount = solution.countNodes(root);
        System.out.println("Number of nodes in the binary tree: " + nodeCount);
    }
}

