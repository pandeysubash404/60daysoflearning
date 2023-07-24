/* Majority Element */
public class Day54 {
    static int majorityElement(int a[], int size) {
        // Step 1: Find the candidate for the majority element
        int majorityCandidate = findCandidate(a, size);

        // Step 2: Verify if the candidate is the majority element
        if (isMajorityCandidate(a, size, majorityCandidate)) {
            return majorityCandidate;
        } else {
            // If there is no majority element, you can return a special value, -1, for example
            return -1;
        }
    }//majorityElement

    static int findCandidate(int a[], int size) {
        int majorityCandidate = a[0]; // Assume the first element is the majority candidate
        int count = 1; // Initialize the count of the majority candidate

        // Traverse through the array to find the majority candidate
        for (int i = 1; i < size; i++) {
            if (a[i] == majorityCandidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    // If count becomes zero, update the majority candidate
                    majorityCandidate = a[i];
                    count = 1;
                }
            }
        }

        return majorityCandidate;
    }//findCandidate

    static boolean isMajorityCandidate(int a[], int size, int candidate) {
        // Count the occurrences of the candidate in the array
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == candidate) {
                count++;
            }
        }

        // Check if the candidate is the majority element
        return count > size / 2;
    }//isMajorityCandidate
    
    public static void main(String[] args) {
        int[] array = { 2, 4, 5, 2, 2, 2, 3, 2, 2 }; // Example array

        int majorityElement = majorityElement(array, array.length);
        if (majorityElement != -1) {
            System.out.println("The majority element is: " + majorityElement);
        } else {
            System.out.println("No majority element found in the array.");
        }
    }//main method
}// Day54 class

