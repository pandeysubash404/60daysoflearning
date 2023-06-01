class Solution{
		//method to check given Integer is palindrome or not
	 public boolean isPalindrome(int x) {
		 //temp variable to hold the changes value
		 //reminder variable to store value of current temp value reminder
		 //sum variable is to sum the value reminder with previous sum value multiplying by 10
		 
	        int reminder, sum=0,temp;

	        //temp holding the integer value send to check palindrome
	        
	        temp =x;

	        while(temp>0){
	            reminder = temp %10;
	            sum=(sum*10)+reminder;    
	            temp=temp/10;    
	        }

	  // if the send integer value and sum value get equal it will return true else false
	    if(x == sum){
	        return true;
	    }else{
	        return false;
	    }

	  }
}s