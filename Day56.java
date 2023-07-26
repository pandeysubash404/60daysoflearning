s
/* Count pairs with given sum  using a HashMap */

import java.util.HashMap;

public class Day56 {
	  int getPairsCount(int[] arr, int n, int k) {
	        // code here
	        // create a HashMap to store the frequency of each element in the array
	        HashMap<Integer, Integer> map = new HashMap<>();

	        // count the frequency of each element and store it in the HashMap
	        for (int i = 0; i < n; i++) {
	            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
	        }

	        int count = 0; // initialize the count of pairs

	        // traverse through the array and find the number of pairs
	        for (int i = 0; i < n; i++) {
	            int complement = k - arr[i]; //complement of the current element to make the sum K

	            // if the complement exists in the HashMap, increment the count by its frequency
	            if (map.containsKey(complement)) {
	                count += map.get(complement);
	            }

	            // if the current element is also a valid complement to itself (arr[i] + arr[i] = K)
	            // then decrement the count as we shouldn't count the same element twice
	            if (complement == arr[i]) {
	                count--;
	            }
	        }

	        // count variable contains the number of pairs whose sum is equal to K
	        // Divide by 2 as each pair is counted twice (for both elements in the pair)
	        return count / 2;

	    }

    public static void main(String[] args) {
    	Day56 day = new Day56();
        int[] arr = { 1, 5, 7, 1 };
        int k = 6;

        int n = arr.length;
        int pairsCount = day.getPairsCount(arr, n, k);

        System.out.println("Number of pairs with sum equal to " + k + " is: " + pairsCount);
    /*
     OutPut :
     Number of pairs with sum equal to 6 is: 2
     */
    }
}
