import java.util.*;

public class MergeSort {

    private static int[] b; // Temporary array

    // Merge Sort function
    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(a, low, mid);       // Left half
            mergeSort(a, mid + 1, high);  // Right half
            merge(a, low, mid, high);     // Merge both halves
        }
    }

    // Merge function
    public static void merge(int[] a, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;

        // Compare and merge
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        // Copy remaining elements of left half
        while (i <= mid) {
            b[k++] = a[i++];
        }

        // Copy remaining elements of right half
        while (j <= high) {
            b[k++] = a[j++];
        }

        // Copy back to original array
        for (int h = low; h <= high; h++) {
            a[h] = b[h];
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        b = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        mergeSort(array, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
