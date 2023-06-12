public class Day12 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	   //nums1 = [1,3], nums2 = [2]
		
		int m = nums1.length;
	    int n = nums2.length;
	    int[] mergedArray = new int[m + n];

	    int i = 0, j = 0, k = 0;
	    //till nums1 and nums2 both length is equal
	    while (i < m && j < n) {
	        if (nums1[i] <= nums2[j]) {
	            mergedArray[k++] = nums1[i++];
	        } else {
	            mergedArray[k++] = nums2[j++];
	        }
	    }//while
	    //yet mergedArray[]={1,2}

	    //till nums1 have element
	    while (i < m) {
	        mergedArray[k++] = nums1[i++];
	    }//yet mergedArray[]={1,2,3}

	    //till nums2 have element
	    while (j < n) {
	        mergedArray[k++] = nums2[j++];
	    }

	    // Calculate the median
	    if ((m + n) % 2 == 0) {
	        int mid = (m + n) / 2;
	        return (mergedArray[mid - 1] + mergedArray[mid]) / 2.0;
	    } else {
	        int mid = (m + n) / 2;
	        return mergedArray[mid];
	    }
	}//findMedianSortedArray
	public static void main(String[] args) {
		Day12 day12 = new Day12();
		int num1[]= {1,3};
		int num2[]= {2};
		
		double result = day12.findMedianSortedArrays(num1, num2);
		System.out.println(result);
	}

}
