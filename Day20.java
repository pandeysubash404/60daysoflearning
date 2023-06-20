/* Split a Circular Linked List into two halves */

public class Day20 {

    // Definition of the circular_LinkedList class
    static class circular_LinkedList {
        Node head; // head of the linked list
        Node head1; // head of the first list after splitting
        Node head2; // head of the second list after splitting

        // Definition of the Node class
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                next = null;
            }
        }

        // Function to split a circular LinkedList
        void splitList(circular_LinkedList list) {
            // DO NOT REMOVE THESE 3 LINES
            Node head = list.head;
            Node head1 = null;
            Node head2 = null;

            // Modify these head1 and head2 here, head is the starting point of our original linked list.
            if (head == null) {
                head1 = null;
                head2 = null;
                return;
            }

            Node slow = head;
            Node fast = head;

            // Move the fast pointer two steps and the slow pointer one step
            while (fast.next != head && fast.next.next != head) {
                fast = fast.next.next;
                slow = slow.next;
            }

            // Check if the number of nodes is even
            if (fast.next.next == head) {
                fast = fast.next;
            }

            // Set the head1 for the first list
            head1 = head;

            // Set the head2 for the second list
            if (head.next != head) {
                head2 = slow.next;
            }

            // Make the second list circular
            fast.next = slow.next;

            // Make the first list circular
            slow.next = head;

            // DO NOT REMOVE THESE 2 LINES
            list.head1 = head1;
            list.head2 = head2;
        }
    }

    // Function to print the circular LinkedList
    static void printCircularLinkedList(circular_LinkedList.Node head) {
        if (head == null)
            return;

        // Create a temporary node to traverse the circular LinkedList
        circular_LinkedList.Node temp = head;

        // Print the elements of the circular LinkedList
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        // Create a circular LinkedList
        circular_LinkedList circularList = new circular_LinkedList();

        // Add nodes to the circular LinkedList
        circularList.head = new circular_LinkedList.Node(1);
        circularList.head.next = new circular_LinkedList.Node(2);
        circularList.head.next.next = new circular_LinkedList.Node(3);
       // circularList.head.next.next.next = new circular_LinkedList.Node(4);
       // circularList.head.next.next.next.next = circularList.head;
        circularList.head.next.next.next = circularList.head;

        // Split the circular LinkedList
        circularList.splitList(circularList);

        // Print the first split list
        System.out.println("First Split List:");
        printCircularLinkedList(circularList.head1);

        // Print the second split list
        System.out.println("\nSecond Split List:");
        printCircularLinkedList(circularList.head2);
    }
}
