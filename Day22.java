/*Linked List Matrix*/

public class Day22 {
	static class Node {
	    int data;
	    Node right, down;

	    Node(int data) {
	        this.data = data;
	        right = null;
	        down = null;
	    }
	}//Node Class
	

    static Node constructLinkedMatrix(int[][] arr, int n) {
        Node[][] nodes = new Node[n][n];

        // Create nodes for each element in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node(arr[i][j]);
            }
        }

        // Connect the nodes horizontally
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                nodes[i][j].right = nodes[i][j + 1];
            }
        }

        // Connect the nodes vertically
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                nodes[i][j].down = nodes[i + 1][j];
            }
        }

        // Return the head of the linked list (top-left element)
        return nodes[0][0];
    }//constructLinkedMatrix()

    static void printLinkedList(Node head) {
        Node currentRow = head;

        while (currentRow != null) {
            Node current = currentRow;

            while (current != null) {
                System.out.print(current.data + "->");
                current = current.right;
            }

            System.out.print("Null->");
            currentRow = currentRow.down;
        }//outer while loop
    }//printLinkedList()
    
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int n = 3;

        Node head = constructLinkedMatrix(mat, n);
        printLinkedList(head);
    }
}
