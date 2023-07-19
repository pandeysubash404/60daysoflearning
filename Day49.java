
/* Kth Largest Sum in a Binary Tree */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Day49 {
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int val) {
	        this.val = val;
	    }
	}

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevel = 0;

        PriorityQueue<Long> maxHeap = new PriorityQueue<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            maxHeap.offer(levelSum);
            currentLevel++;

            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the smallest level sum from the heap
            }
        }

        if (currentLevel < k) {
            return -1; // Fewer than k levels in the tree
        }

        return maxHeap.peek(); // The kth largest level sum
    }

    public static void main(String[] args) {
        /*
               1
              / \
             2   3
            / \   \
           4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int k = 2;
        Day49 solution = new Day49();
        long result = solution.kthLargestLevelSum(root, k);
        System.out.println("The " + k + "th largest level sum is: " + result); 
        // Output: The 2th largest level sum is: 9
    }
}
