/*  Longest Palindromic Substring   */
public class Day27 {    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Check for odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Check for even-length palindromes
            
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
	
    public static void main(String[] args) {
    	Day27 day = new Day27();
        String s1 = "babad";
        System.out.println("Longest palindromic substring: " + day.longestPalindrome(s1)); // Output: "bab" or "aba"
        
        String s2 = "cbbd";
        System.out.println("Longest palindromic substring: " + day.longestPalindrome(s2)); // Output: "bb"
    }
}
