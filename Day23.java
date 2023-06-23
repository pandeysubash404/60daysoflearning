/* Reorder List
	
	Given a linked list of the form:
	N0 → N1 → N2 → ....Nn-2 → Nn-1
	
	Reorder the list in the following format:
	N0 → Nn-1 → N1 → Nn-2 → N2 → ....
	 */

public class Day23 {
	
	static class ListNode {
	    int val;
	    ListNode next;

	    ListNode(int val) {
	        this.val = val;
	        this.next = null;
	    }
	}
	

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle node
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null; // Split the list

        // Step 2: Reverse the second half
        ListNode prev = null;
        ListNode current = secondHalf;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode reversedSecondHalf = prev;

        // Step 3: Merge the first and reversed second halves alternatively
        ListNode mergedList = new ListNode(-1); // Dummy node
        ListNode currentMerged = mergedList;
        ListNode currentFirstHalf = head;
        ListNode currentReversed = reversedSecondHalf;

        while (currentFirstHalf != null && currentReversed != null) {
            currentMerged.next = currentFirstHalf;
            currentFirstHalf = currentFirstHalf.next;
            currentMerged = currentMerged.next;

            currentMerged.next = currentReversed;
            currentReversed = currentReversed.next;
            currentMerged = currentMerged.next;
        }

        // If the first half is longer, append the remaining nodes
        if (currentFirstHalf != null) {
            currentMerged.next = currentFirstHalf;
        }

        return mergedList.next;
    }//reorderList()

    public static void printLinkedList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }//printLinkedList()
    public static void main(String[] args) {
        // Example usage
    	// 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reorderedList = reorderList(head);
        printLinkedList(reorderedList);
    }
}

