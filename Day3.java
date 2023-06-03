public class Day3 {
	public String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0) {
	        return "";
	    }

	    String prefix = strs[0]; // Start with the first string as the prefix
	    for (int i = 1; i < strs.length; i++) {
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1); // Trim the last character from the prefix
	            if (prefix.isEmpty()) {
	                return ""; // No common prefix found
	            }
	        }
	    }

	    return prefix;
	}

	public static void main(String[] args) {
		Day3 day3 = new Day3();
		
		String[] arr1 = {"flower","flow","flight"};
		String[] arr2 = {"dog","racecar","car"};
		String[] arr3 = {"empty","empt","emp","em"};
		
		
		String result = day3.longestCommonPrefix(arr3);
		System.out.println(result);
	}

}
