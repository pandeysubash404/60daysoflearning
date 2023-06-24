
/*  Next Permutation */

import java.util.Arrays;
public class Day24 {
    public static void nextPermutation(int[] nums) {
    	 int n = nums.length;
    	    
    	    // Step 1: Find the first pair of adjacent elements from the right
    	    // where the left element is smaller than the right element
    	    int i = n - 2;
    	    while (i >= 0 && nums[i] >= nums[i + 1]) {
    	        i--;
    	    }
    	    
    	    // Step 2: If there is no such pair, reverse the entire array
    	    // to get the next lexicographically smaller permutation
    	    if (i < 0) {
    	        reverse(nums, 0, n - 1);
    	        return;
    	    }
    	    
    	    // Step 3: Find the smallest element in the right subarray
    	    // that is greater than nums[i]
    	    int j = n - 1;
    	    while (j > i && nums[j] <= nums[i]) {
    	        j--;
    	    }
    	    
    	    // Step 4: Swap elements at indices i and j
    	    swap(nums, i, j);
    	    
    	    // Step 5: Reverse the elements in the right subarray
    	    reverse(nums, i + 1, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = { 1, 2, 3 };
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // [1, 3, 2]

        // Example 2
        int[] nums2 = { 2, 3, 1 };
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [3, 1, 2]

        // Example 3
        int[] nums3 = { 3, 2, 1 };
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1, 2, 3]
    }
}

