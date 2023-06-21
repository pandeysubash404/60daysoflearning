/* Check if Linked List is Palindrome */

public class Day21 {
    
    // Definition of the Node class
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Base case: An empty list or a single node is a palindrome
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the linked list
        Node secondHalf = reverseList(slow.next);
        
        // Compare the first half and the reversed second half of the linked list
        Node firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false; // Nodes are not equal, not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true; // All nodes are equal, palindrome
    }
    
    // Function to reverse a linked list
    Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        return prev;
    }
    
    // Function to create a linked list from an array
    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tail = null;
        
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        Day21 day21 = new Day21();
        
        // Example 1:
        int[] arr1 = {1, 2, 3, 2, 1};
        Node head1 = day21.createLinkedList(arr1);
        System.out.println("Example 1:");
        System.out.println("Linked List: 1 -> 2 -> 3 -> 2 -> 1");
        System.out.println("Is Palindrome: " + day21.isPalindrome(head1));
        
        // Example 2:
        int[] arr2 = {1, 2, 3, 4, 5};
        Node head2 = day21.createLinkedList(arr2);
        System.out.println("\nExample 2:");
        System.out.println("Linked List: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Is Palindrome: " + day21.isPalindrome(head2));
    }//main method
}//Day21 class
