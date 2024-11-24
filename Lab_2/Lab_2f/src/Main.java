import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        int[] array2 = new int[100_00];
        fillArrayWithRandomValues(array,100, 1000);
        fillArrayWithRandomValues(array2,100, 1000);
        int len = array.length;
        int len2 = array2.length;

        System.out.println("Quick Sort");
        // printArray(array);
        long startTime = System.currentTimeMillis();
        QuickSort.quickSort(array, 0, len - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted array by quick sort");
        // printArray(array);
        long durationMillis = endTime - startTime;
        double durationSeconds = durationMillis / 1000.0;
        System.out.printf("Quick Sort Execution time: %.7f seconds%n", durationSeconds);

        System.out.println("Merge Sort");
        // printArray(array2);
        startTime = System.currentTimeMillis();
        MergeSort.sort(array2, 0, len2 - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Sorted array by merge sort");
        // printArray(array2);
        durationMillis = endTime - startTime;
        durationSeconds = durationMillis / 1000.0;
        System.out.printf("Merge Sort Execution time: %.7f seconds%n", durationSeconds);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void fillArrayWithRandomValues(int[] array, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min; // Genereaza valori intre min si max
        }
    }
}
