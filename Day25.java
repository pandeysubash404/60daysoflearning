/* Remove loop in Unsorted Linked List*/

public class Day25 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return; // No loop present
        }

        Node slow = head;
        Node fast = head;

        // Detect if a loop exists
        boolean loopExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break; // Loop found
            }
        }

        if (!loopExists) {
            return; // No loop present
        }

        // Move slow back to the head and advance both pointers until they meet at the loop start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Find the last node of the loop
        Node loopNode = slow;
        while (fast.next != loopNode) {
            fast = fast.next;
        }

        // Unlink the last node from the loop
        fast.next = null;
    }

    public static void main(String[] args) {
        // Create a linked list with a loop
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop by connecting the last node to the second node
        head.next.next.next.next.next = head.next.next;

        System.out.println("Linked list before removing the loop:");
        printLinkedList(head);

        // Remove the loop
        removeLoop(head);

        System.out.println("Linked list after removing the loop:");
        printLinkedList(head);
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
