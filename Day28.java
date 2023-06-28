/* left rotation operation on an array  */

import java.util.ArrayList;
import java.util.List;

public class Day28 {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size();
        int rotations = d % n; // Adjust the number of rotations if it exceeds the array size
        
        List<Integer> rotatedArr = new ArrayList<>(n);
        
        // Perform the rotation
        for (int i = rotations; i < n; i++) {
            rotatedArr.add(arr.get(i));
        }
        
        for (int i = 0; i < rotations; i++) {
            rotatedArr.add(arr.get(i));
        }
        
        return rotatedArr;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        
        int d = 2;
        
        List<Integer> rotatedArr = rotateLeft(d, arr);
        
        System.out.println("Original array: " + arr);
        System.out.println("Rotated array: " + rotatedArr);
    }


}

