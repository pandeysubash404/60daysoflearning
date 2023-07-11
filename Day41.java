/* Boundary Traversal of binary tree */

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Day41 {
	
	ArrayList<Integer> boundary(Node node)
	{
	    ArrayList<Integer> res = new ArrayList<>();
	    if(node == null) return res;
	    res.add(node.data);
	    leftBoundary(node.left, res);
	    leaves(node.left, res);
	    leaves(node.right, res);
	    rightBoundary(node.right, res);
	    return res;
	}

	void leftBoundary(Node node, ArrayList<Integer> res)
	{
	    if(node == null) return;
	    if(node.left != null)
	    {
	        res.add(node.data);
	        leftBoundary(node.left, res);
	    }
	    else if(node.right != null)
	    {
	        res.add(node.data);
	        leftBoundary(node.right, res);
	    }
	}

	void rightBoundary(Node node, ArrayList<Integer> res)
	{
	    if(node == null) return;
	    if(node.right != null)
	    {
	        rightBoundary(node.right, res);
	        res.add(node.data);
	    }
	    else if(node.left != null)
	    {
	        rightBoundary(node.left, res);
	        res.add(node.data);
	    }
	}

	void leaves(Node node, ArrayList<Integer> res)
	{
	    if(node == null) return;
	    leaves(node.left, res);
	    if(node.left == null && node.right == null) 
	        res.add(node.data);
	    leaves(node.right, res);
	}

	
    public static void main(String[] args) {
    	Day41 day = new Day41();
    	
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        ArrayList<Integer> res = day.boundary(root);
        System.out.println("Boundary values in anti-clockwise order: " + res.toString());
    }
}

