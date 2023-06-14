
	//JAVA Code for left Rotation of a
	// matrix by 90 degree without using
	// any extra space

import java.util.*;
public class Day14 {

	// Function for do transpose of matrix
			static void transpose(int arr[][])
			{
				for (int i = 0; i < arr.length; i++)
					for (int j = i; j < arr[0].length; j++) {
						int temp = arr[j][i];
						arr[j][i] = arr[i][j];
						arr[i][j] = temp;
					}
			}
			
		// After transpose we swap elements of
		// column one by one for finding left
		// rotation of matrix by 90 degree
		static void reverseColumns(int arr[][])
		{
			for (int i = 0; i < arr[0].length; i++)
				for (int j = 0, k = arr[0].length - 1; j < k;
					j++, k--) {
					int temp = arr[j][i];
					arr[j][i] = arr[k][i];
					arr[k][i] = temp;
				}
		}
		// Function to anticlockwise rotate
		// matrix by 90 degree
		static void rotate90(int arr[][])
		{
			transpose(arr);
			reverseColumns(arr);
		}


public static void main(String[] args)
		{
			int arr[][] = { { 1, 2, 3, 4 },
							{ 5, 6, 7, 8 },
							{ 9, 10, 11, 12 },
							{ 13, 14, 15, 16 } 
						  };

			rotate90(arr);
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println("");
			}
		}
	}

