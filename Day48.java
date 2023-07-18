

/* Find a pair with given target in BST */

import java.util.ArrayList;
import java.util.List;

public class Day48 {
	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}// class Node

	public static int isPairPresent(Node root, int target) {
		if (root == null)
			return 0;

		List<Integer> inorder = new ArrayList<>();
		inorderTraversal(root, inorder);

		int left = 0;
		int right = inorder.size() - 1;

		while (left < right) {
			int sum = inorder.get(left) + inorder.get(right);
			if (sum == target)
				return 1;
			else if (sum < target)
				left++;
			else
				right--;
		}

		return 0;
	}// isPairPresent()

	private static void inorderTraversal(Node root, List<Integer> inorder) {
		if (root == null)
			return;

		inorderTraversal(root.left, inorder);
		inorder.add(root.data);
		inorderTraversal(root.right, inorder);
	}// inorderTraversal()

	public static void main(String[] args) {
		// Create a BST
		
		/*
		       	    5
			   / \
			  3   7
			 / \ / \
			2  4 6  8

		 */
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(8);

		int target = 9;
		int isPairPresent = isPairPresent(root, target);

		if (isPairPresent == 1) {
			System.out.println("There is a pair of nodes in the BST that sums up to " + target);
		} else {
			System.out.println("No such pair exists in the BST");
		}
	}

}
