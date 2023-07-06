/* Kadane's Algorithm */
public class Day36 {
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n) {
    	long maxSum = Integer.MIN_VALUE; // Initialize maxSum with the smallest possible value
        long currentSum = 0; // Initialize currentSum as 0

        for (int i = 0; i < n; i++) {
            currentSum += arr[i]; // Add the current element to the current sum

            if (currentSum > maxSum) {
                maxSum = currentSum; // Update maxSum if currentSum is greater
            }

            if (currentSum < 0) {
                currentSum = 0; // If currentSum becomes negative, reset it to 0
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = arr.length;

        Day36 day36 = new Day36();
        long maxSum = day36.maxSubarraySum(arr, n);
        System.out.println("Maximum sum of a contiguous subarray: " + maxSum);
    }
}
