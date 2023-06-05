import java.util.Stack;
public class Day5 {
	
	 public static boolean isValid(String s) {
		 Stack<Character> stack = new Stack<>();
		 for (char c : s.toCharArray()) {
			 // push opening bracket on stack
		        if (c == '(' || c == '{' || c == '[') {
		            stack.push(c);
		        } 
		    //pop opening bracket while there is closing
		        else if (c == ')' || c == '}' || c == ']') {
		            if (stack.isEmpty() || !isMatchingPair(stack.peek(), c)) {
		                return false;
		            }
		            stack.pop();
		        }
		 	}
		 return stack.isEmpty();
	    }
	 
	 private static boolean isMatchingPair(char opening, char closing) {
		 if(opening == '(' && closing == ')') {
			 return true;
		 }else if(opening == '{' && closing == '}') {
			 return true;
		 }else if(opening == '[' && closing == ']') {
			 return true;
		 }else {
			 return false;
		 }
	}
public static void main(String [] args) {
	Day5 day5 = new Day5();
	String s ="({[})";
	if(day5.isValid(s)) {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
}
}
