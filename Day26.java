/* Longest Substring Without Repeating Characters */

import java.util.Arrays;

public class Day26 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndexes = new int[128]; // Assuming ASCII characters

        // Initialize all character indexes to -1
        Arrays.fill(charIndexes, -1);

        int start = 0;

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);

            // Check if the character is already present in the current substring
            if (charIndexes[c] >= start) {
                // Update the start index to the next position after the repeated character
                start = charIndexes[c] + 1;
            }

            // Update the index of the current character
            charIndexes[c] = end;

            // Calculate the length of the current substring
            int length = end - start + 1;

            // Update the maximum length if necessary
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); // Output: 3
    }
}

