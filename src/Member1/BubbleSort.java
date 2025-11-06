package Member1;

public class BubbleSort {
	public static int steps = 0;

    public static int[] sort(int[] arr) {
        steps = 0; // Reset before sorting
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble Sort Steps: " + steps);
        return arr;
    }
    public static int getSteps() {
        return steps;
    }
}


    
