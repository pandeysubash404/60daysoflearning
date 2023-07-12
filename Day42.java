/* Binary Tree Right Side View  */

import java.util.*;

public class Day42 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int rightmostValue = 0;  // Initialize with a default value
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // Update the rightmost value at each level
                rightmostValue = currentNode.val;
                
                // Add the left and right child nodes to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            // Add the rightmost value of the current level to the result list
            result.add(rightmostValue);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        
        // Call rightSideView function
        List<Integer> rightSideValues = rightSideView(root);
        
        // Print the output
        System.out.println("Right Side View: " + rightSideValues);
    }
}
