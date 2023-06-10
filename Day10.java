import java.util.*;

public class Day10 {
	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here
		int length = grades.size();
		for (int i = 0; i < length; i++) {
			if (grades.get(i) < 38) {
				continue;
			} else {
				int marks = ((grades.get(i) / 5) * 5) + 5;
				if ((marks - grades.get(i)) < 3) {
					grades.set(i, marks);
				} // if
			} // else
		} // for
		return grades;
	}// gradingStudents

	public static void main(String[] args) {
		Day10 day10 = new Day10();

		List<Integer> grades = new ArrayList<Integer>();

		// Adding elements to object of List interface
		// Custom inputs

		int arr[] = { 73, 67, 38, 33 };

		for (int i = 0; i < arr.length; i++) {
			grades.add(i, arr[i]);
		}

		List<Integer> result = day10.gradingStudents(grades);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}

}
