package sorting;

public class QuickSort {

    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            sort(array, left, pivot - 1);
            sort(array, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, partitionIndex, right);
        return partitionIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {5, 76, 1, 6, 23, 17, 31, 3, 14};
        printArray(array);
        sort(array, 0, array.length - 1);
        printArray(array);
    }
}
