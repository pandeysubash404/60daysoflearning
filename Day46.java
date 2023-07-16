/* Find Bottom Left Tree Value */
import java.util.*;

public class Day46 {
	static class TreeNode {
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
	
	 public int findBottomLeftValue(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        TreeNode leftmost = null;

	        while (!queue.isEmpty()) {
	            int levelSize = queue.size();
	            leftmost = queue.peek();

	            for (int i = 0; i < levelSize; i++) {
	                TreeNode node = queue.poll();

	                if (node.left != null) {
	                    queue.offer(node.left);
	                }
	                if (node.right != null) {
	                    queue.offer(node.right);
	                }
	            }
	        }

	        return leftmost.val;
	    }
    public static void main(String[] args) {
        /*
                    2
                   / \
                  1   3
                         \
                          4
        */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        Day46 day = new Day46();
        int leftmostValue = day.findBottomLeftValue(root);

        System.out.println("Leftmost value in the last row: " + leftmostValue);
    }
}
