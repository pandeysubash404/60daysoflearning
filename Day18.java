

/* Circular Linked List Traversal */

import java.util.*;
import java.io.*;

public class Day18 {
	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}

	}// Node Class
	static class Solution {
		/* Function to print nodes in a given Circular linked list */
		void printList(Node head) {
			// Your code here
			Node currNode = head;

			// linked list is empty
			if (head == null) {
				return;
			} else {

				do {
					System.out.print(currNode.data + " ");
					currNode = currNode.next;
				} while (currNode != head);
			}
		}// else
	}// Solution Class
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes :");
		int n = sc.nextInt();
		System.out.println("Enter head node :");
		Node head = new Node(sc.nextInt());
		Node tail = head;

		for (int i = 0; i < n - 1; i++) {
			System.out.println("Enter nodes :");
			Node newNode = new Node(sc.nextInt());
			newNode.next = head;
			head = newNode;
		}
		tail.next = head;

		Solution ob = new Solution();
		ob.printList(head);
		System.out.println();

	}//main method
}//Day18 Class


