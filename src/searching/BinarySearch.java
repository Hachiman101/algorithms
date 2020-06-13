package searching;

public class BinarySearch {
    public static int search(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (value < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 14, 17, 23, 31, 76};
        System.out.println(search(array, 6));
        System.out.println(search(array, 50));
    }
}
