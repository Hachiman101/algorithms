package sorting;

public class MergeSort {

    public static void sort(int[] array, int leftIncl, int rightExcl) {
        if (rightExcl <= leftIncl + 1) {
            return;
        }

        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        sort(array, leftIncl, middle);
        sort(array, middle, rightExcl);

        merge(array, leftIncl, middle, rightExcl);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int i = left;
        int j = middle;
        int k = 0;

        int[] temp = new int[right - left];

        while (i < middle && j < right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        for (; i < middle; i++, k++) {
            temp[k] = array[i];
        }

        for (; j < right; j++, k++) {
            temp[k] = array[j];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
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
        sort(array, 0, array.length);
        printArray(array);
    }
}
