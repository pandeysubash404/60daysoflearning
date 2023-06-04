
import java.util.*;
public class Day4 {
	 public static int diagonalDifference(List<List<Integer>> arr) {
		    // Write your code here
		     int rtl=0;
		     int ltr=0;
		     int size = arr.size();

		    for (int i = 0; i < size; i++) {
		        rtl += arr.get(i).get(i); // right-to-left diagonal 
		        ltr += arr.get(i).get(size - 1 - i); //  left-to-right diagonal 
		    }
		    return Math.abs(rtl-ltr);
		    
		    }
	public static void main(String[] args) {
		Day4 day4 = new Day4();
		
		List<List<Integer>> arr = new ArrayList<>();

		// Create the first row
		List<Integer> row1 = new ArrayList<>();
		row1.add(11);
		row1.add(2);
		row1.add(4);
		arr.add(row1);

		// Create the second row
		List<Integer> row2 = new ArrayList<>();
		row2.add(4);
		row2.add(5);
		row2.add(6);
		arr.add(row2);

		// Create the third row
		List<Integer> row3 = new ArrayList<>();
		row3.add(10);
		row3.add(8);
		row3.add(-12);
		arr.add(row3);

		//calling the method
		int difference  = day4.diagonalDifference(arr);
		System.out.println("The absolute difference between the sums of the matrix's two diagonals is : "+difference);
				
		}

	}


