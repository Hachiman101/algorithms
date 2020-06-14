package sorting;

public class CountingSort {

    public static int[] sort(int[] array, int max) {
        int k = max + 1;
        int[] counts = new int[k];

        for (int value : array) {
            counts[value]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i - 1] + counts[i];
        }

        int[] sorted = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int rightIndex = counts[array[i]] - 1;
            sorted[rightIndex] = array[i];
            counts[array[i]]--;
        }

        return sorted;
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 9, 1, 0, 5, 6};
        printArray(array);
        printArray(sort(array, 10));
    }
}
