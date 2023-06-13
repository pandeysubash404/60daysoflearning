import java.util.*;
public class Day13 {
	public static List<Integer> absolutePermutation(int n, int k) {
	         List<Integer> permutation = new ArrayList<>();

	    // Check for special cases
	    if (k == 0) {
	        // If k is 0, return the numbers from 1 to n in ascending order
	        for (int i = 1; i <= n; i++) {
	            permutation.add(i);
	        }
	    } else if (n % (2 * k) == 0) {
	        // If n is divisible by 2k
	        for (int i = 1; i <= n; i++) {
	            int target = (i - 1) / k;
	            if (target % 2 == 0) {
	                permutation.add(i + k);
	            } else {
	                permutation.add(i - k);
	            }
	        }
	    } else {
	        permutation.add(-1); // No valid permutation exists
	    }

	    return permutation;
	    }
	public static void main(String[] args) {
		int n=3;
		int k=0;
		List<Integer> result= absolutePermutation(n,k);
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
