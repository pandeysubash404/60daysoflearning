/* Implement a Stack using two queues q1 and q2. */

import java.util.LinkedList;
import java.util.Queue;

class Queues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Function to push an element into the stack using two queues.
    void push(int x) {
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // Add the new element to q1
        q1.add(x);

        // Move back all elements from q2 to q1
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    // Function to pop an element from the stack using two queues.
    int pop() {
        if (q1.isEmpty()) {
            return -1; // Stack is empty
        }

        // Return the top element from q1 (which is the top of the stack)
        return q1.poll();
    }
}


public class Day31 {
	public static void main(String[] args) {
		 Queues stack = new Queues();
	        
	        stack.push(10);
	        stack.push(20);
	        stack.push(30);
	        
	        System.out.println(stack.pop());  // Output: 30
	        System.out.println(stack.pop());  // Output: 20
	        System.out.println(stack.pop());  // Output: 10
	        System.out.println(stack.pop());  // Output: -1 (stack is empty)

	}

}
