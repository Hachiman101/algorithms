package searching;

public class LinearSearch {
    public static int search(int[] array, int value) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] array = {5, 76, 1, 6, 23, 17, 31, 3, 14};
        System.out.println(search(array, 6));
        System.out.println(search(array, 50));
    }
}
