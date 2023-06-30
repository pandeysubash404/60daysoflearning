/* Zigzag Conversion */

public class Day30 {
	public String convert(String s, int numRows) {
	    // Special case when numRows is 1 or the string is empty
	    if (numRows == 1 || s.length() == 0) {
	        return s;
	    }

	    StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
	    for (int i = 0; i < rows.length; i++) {
	        rows[i] = new StringBuilder();
	    }

	    int currentRow = 0;
	    boolean goingDown = false;

	    for (char c : s.toCharArray()) {
	        rows[currentRow].append(c);

	        if (currentRow == 0 || currentRow == numRows - 1) {
	            goingDown = !goingDown;
	        }

	        currentRow += goingDown ? 1 : -1;
	    }

	    StringBuilder result = new StringBuilder();
	    for (StringBuilder row : rows) {
	        result.append(row);
	    }

	    return result.toString();
	}

	public static void main(String[] args) {
		Day30 day = new Day30();
		
		String input = "PAYPALISHIRING";
		int numRows = 3;

		String converted = day.convert(input, numRows);
		System.out.println(converted);


	}

}
