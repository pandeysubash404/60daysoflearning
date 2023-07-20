/*Merge two binary Max heaps */

public class Day50 {

    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int[] mergedHeap = new int[n + m];

        // Copy elements from array 'a' to the merged heap
        System.arraycopy(a, 0, mergedHeap, 0, n);

        // Copy elements from array 'b' to the merged heap
        System.arraycopy(b, 0, mergedHeap, n, m);

        // Perform heapify to restore the max heap property
        for (int i = (n + m) / 2 - 1; i >= 0; i--) {
            heapify(mergedHeap, n + m, i);
        }

        return mergedHeap;
    }

    // Helper function to heapify the array
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            // Swap elements and recursively heapify the affected subtree
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
    public static void main(String[] args) {
        int[] a = { 10, 8, 5, 3, 2 };
        int[] b = { 15, 12, 6, 4, 1 };

        int n = a.length;
        int m = b.length;

        int[] mergedHeap = mergeHeaps(a, b, n, m);

        System.out.println("Merged Max Heap:");
        for (int num : mergedHeap) {
            System.out.print(num + " ");
        }
        /*
         Output :
         Merged Max Heap:
		 15 8 12 6 2 5 10 3 4 1 
         */
    }
}

