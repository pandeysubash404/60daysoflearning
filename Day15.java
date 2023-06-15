
import java.util.*;
public class Day15 {
	static class Node{
      int data;
      Node next;
      Node(int d) {data = d; next = null; }
  }
	
 static class Remove_Duplicate_From_LL{
  Node head;  
  Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
    void printList()
  {
      Node temp = head;
      while (temp != null)
      {
         System.out.print(temp.data+" ");
         temp = temp.next;
      }  
      System.out.println();
  }
}//remove_duplicate_class

static class Duplicate {
	  // Function to remove duplicates from sorted linked list.
	  Node removeDuplicates(Node head) {
	      // Check if the list is empty or contains only one element
	      if (head == null || head.next == null) {
	          return head;
	      }

	      Node currNode = head;
	      while (currNode != null && currNode.next != null) {
	          if (currNode.data == currNode.next.data) {
	              currNode.next = currNode.next.next;
	          } else {
	              currNode = currNode.next;
	          }
	      }
	      
	      return head;
	  }
}//Duplicate
	public static void main(String args[])
  {
       Scanner sc = new Scanner(System.in);
       System.out.println("Times to check : ");
		 int t=sc.nextInt();
		 while(t>0){
			 System.out.println("Enter the number of nodes : ");
			int n = sc.nextInt();
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
			 System.out.println("Head node data : ");
			int a1=sc.nextInt();
			Node head= new Node(a1);
          llist.addToTheLast(head);
          for (int i = 1; i < n; i++){
        	  System.out.println("Node data : ");
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
      Duplicate g = new Duplicate();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList();
		
      t--;		
      }//while
  }//main
}//day15 class

