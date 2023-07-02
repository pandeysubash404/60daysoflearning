/* Sort an array of 0s, 1s and 2s */
public class Day32 {
    public static void sort012(int a[], int n) {
        int low = 0;        // Pointer for the low section
        int mid = 0;        // Pointer for the middle section
        int high = n - 1;   // Pointer for the high section

        while (mid <= high) {
            if (a[mid] == 0) {
                // If the element is 0, swap it with the element at the low pointer
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                // If the element is 1, move to the next element
                mid++;
            } else if (a[mid] == 2) {
                // If the element is 2, swap it with the element at the high pointer
                swap(a, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap two elements in an array
    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        // Sample input
        int[] arr = {0, 2, 1, 2, 0};
        int size = arr.length;

        // Sorting the array
        sort012(arr, size);

        // Printing the sorted array
        System.out.print("Sorted Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
