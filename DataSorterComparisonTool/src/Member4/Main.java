package Member4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[0];

        while (true) {
            System.out.println("\n--- Data Sorter Menu ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Compare All");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("How many numbers? ");
                    int n = scanner.nextInt();
                    data = new int[n];
                    System.out.println("Enter numbers:");
                    for (int i = 0; i < n; i++) {
                        data[i] = scanner.nextInt();
                    }
                    break;

                case 2:
                    System.out.print("How many random numbers? ");
                    int size = scanner.nextInt();
                    data = new int[size];
                    for (int i = 0; i < size; i++) {
                        data[i] = (int)(Math.random() * 100);
                    }
                    System.out.println("Generated: " + Arrays.toString(data));
                    break;

                case 3:
                    int[] bubble = Arrays.copyOf(data, data.length);
                    long bubbleTime = Timer.measure(() -> BubbleSort.sort(bubble));
                    System.out.println("Bubble Sorted: " + Arrays.toString(bubble));
                    System.out.println("Time: " + bubbleTime + " ns");
                    break;

                case 4:
                    int[] mergeInput = Arrays.copyOf(data, data.length);
                    int[] mergeResult = new int[mergeInput.length];
                    long mergeTime = Timer.measure(() -> {
                        int[] sorted = MergeSort.sort(mergeInput);
                        System.arraycopy(sorted, 0, mergeResult, 0, sorted.length);
                    });
                    System.out.println("Merge Sorted: " + Arrays.toString(mergeResult));
                    System.out.println("Steps: " + MergeSort.getSteps());
                    System.out.println("Time: " + mergeTime + " ns");
                    break;


                case 5:
                    int[] quick = Arrays.copyOf(data, data.length);
                    long quickTime = Timer.measure(() -> QuickSort.sort(quick, 0, quick.length - 1));
                    System.out.println("Quick Sorted: " + Arrays.toString(quick));
                    System.out.println("Steps: " + QuickSort.getSteps());
                    System.out.println("Time: " + quickTime + " ns");
                    break;

                case 6:
                    int[] bubbleData = Arrays.copyOf(data, data.length);
                    int[] mergeData = Arrays.copyOf(data, data.length);
                    int[] quickData = Arrays.copyOf(data, data.length);

                    long BubbleTime = Timer.measure(() -> BubbleSort.sort(bubbleData));
                    long MergeTime = Timer.measure(() -> MergeSort.sort(mergeData));
                    long QuickTime = Timer.measure(() -> QuickSort.sort(quickData, 0, quickData.length - 1));

                    int bubbleSteps = BubbleSort.getSteps();
                    int mergeSteps = MergeSort.getSteps();
                    int quickSteps = QuickSort.getSteps();

                    System.out.println("\n--- Comparison Table ---");
                    System.out.printf("%-15s %-15s %-10s\n", "Algorithm", "Time (ns)", "Steps");
                    System.out.printf("%-15s %-15d %-10d\n", "Bubble Sort", BubbleTime, bubbleSteps);
                    System.out.printf("%-15s %-15d %-10d\n", "Merge Sort", MergeTime, mergeSteps);
                    System.out.printf("%-15s %-15d %-10d\n", "Quick Sort", QuickTime, quickSteps);
                    break;


                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
