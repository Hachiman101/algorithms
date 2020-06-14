package sorting;

public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }

            int min = array[index];
            array[index] = array[i];
            array[i] = min;
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
