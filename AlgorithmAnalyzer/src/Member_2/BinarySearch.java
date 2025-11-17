package Member_2;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    // Generate random array
    public static int[] generateArray(int size) {
        Random rand = new Random(42); // fixed seed -> same numbers every run
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }

    // Binary Search implementation
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);

            // STEP 1: Sort array before Binary Search
            Arrays.sort(arr);

            // STEP 2: Choose a target element (last element)
            int target = arr[size - 1];

            // STEP 3: Measure time
            long start = System.nanoTime();
            binarySearch(arr, target);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1e6;

            // Output result
            System.out.printf("%d\t|\t%.5f\n", size, timeMs);
        }
    }
}
