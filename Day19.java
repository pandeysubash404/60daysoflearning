/* Intersection of two sorted Linked lists */
public class Day19 {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node findIntersection(Node head1, Node head2) {
    	
    	//Dummy to simplify the creation of the result linked list
        Node dummy = new Node(0);
        //Tail keeps track of the last node in the result list
        Node tail = dummy;

        while (head1 != null && head2 != null) {
        	/*
        	  If the values are equal, it creates a new node with that value
        	  and appends it to the result list.
        	*/
            if (head1.data == head2.data) {
                tail.next = new Node(head1.data);
                tail = tail.next;
                head1 = head1.next;
                head2 = head2.next;
            }
            /*
             *  it means that head1 does not intersect with head2 at the current node.
             */
            else if (head1.data < head2.data) {
                head1 = head1.next;
            } 
            
            else {
                head2 = head2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create the first linked list: 1->2->3->4->6
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);

        // Create the second linked list: 2->4->6->8
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        // Find the intersection of the two linked lists
        Node intersection = findIntersection(head1, head2);

        // Print the intersection elements
        System.out.println("Intersection: ");
        while (intersection != null) {
            System.out.print(intersection.data + " ");
            intersection = intersection.next;
        }
    }//main method
}//Day19 class
