/**
 * Created by danil on 10/2/17.
 * http://www.java2novice.com/java-sorting-algorithms/quick-sort/
 */

public class QuickSort {
    // Puts smaller number to the beginning (replacing with existing elements) of the array.
    // Last step - puts pivot element in the right place after all that smaller numbers.
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // low: Starting index
    // high: Ending index
    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // partitioning index
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        System.out.println("Quick sort implementation");
        int arr[] = {10, 7, 8, 9, 1, 5}; // size = 6
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
