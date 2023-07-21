/* K largest elements by heap */

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Day51 {

    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        // Create a Min Heap of size k to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // If the size of the Min Heap is less than k, simply add the element
            if (minHeap.size() < k) {
                minHeap.add(arr[i]);
            } else {
                // If the current element is greater than the root of the Min Heap,
                // remove the root and insert the current element
                if (arr[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(arr[i]);
                }
            }
        }

        // The Min Heap now contains the k largest elements
        // Extract them and add to the result list
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        // Reverse the list to get the elements in descending order
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 10, 4, 3, 20, 15 };
        int n = arr.length;
        int k = 3;

        ArrayList<Integer> result = kLargest(arr, n, k);

        System.out.println("K largest elements in the array are: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        /*
         Output :
         K largest elements in the array are: 15 20 10
         */
    }
}

