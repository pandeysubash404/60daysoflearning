
public class Day6 {
	public int removeDuplicates(int[] nums) {
	    if (nums == null || nums.length == 0) {
	        return 0; // Empty array
	    }

	    int n = nums.length;
	    int i = 0; // Slow pointer

	    for (int j = 1; j < n; j++) { // Fast pointer
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j]; // Update the value at i with the new unique element
	        }
	    }//for

	    return i + 1; // Return the length of the updated array (i + 1)
	}

	public static void main(String[] args) {
		Day6 day6 = new Day6();
		int arr[]= {0,0,1,1,1,2,2,3,3,4};
		int max_index=day6.removeDuplicates(arr);
		System.out.println("The length of the updated array is : "+max_index);
	
	}

}
