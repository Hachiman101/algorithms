package sorting;

public class InsertionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > element) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = element;
        }
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
        sort(array);
        printArray(array);
    }
}
