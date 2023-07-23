/* Max Sum of a Pair With Equal Sum of Digits with heap */

import java.util.HashMap;
import java.util.Map;

public class Day53 {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> sumOfDigitsMap = new HashMap<>();
        int maxSum = -1;

        // Helper function to calculate the sum of digits for a given number
        // This function is optional as you can also calculate the sum of digits directly in the main loop
        // but using a separate function can make the code more modular and readable
        // For example:
        // int sumOfDigits = calculateSumOfDigits(nums[i]);

        for (int num : nums) {
            int sumOfDigits = calculateSumOfDigits(num);
            
            if (sumOfDigitsMap.containsKey(sumOfDigits)) {
                int otherNum = sumOfDigitsMap.get(sumOfDigits);
                maxSum = Math.max(maxSum, num + otherNum);
            }

            // Update the map with the current number and its sum of digits
            sumOfDigitsMap.put(sumOfDigits, Math.max(num, sumOfDigitsMap.getOrDefault(sumOfDigits, num)));
        }

        return maxSum;
    }

    // Helper function to calculate the sum of digits for a given number
    private int calculateSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Day53 solution = new Day53();
        int[] nums = { 10, 12, 19, 14 };
        int result = solution.maximumSum(nums);
        System.out.println("Maximum sum: " + result); // Output: -1
    }
}

