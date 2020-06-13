package searching;

public class JumpSearch {
    public static int search(int[] array, int value) {
        int previousRight = 0;
        int currentRight = 0;
        int jumpLength = (int) Math.sqrt(array.length);

        if (array.length == 0) {
            return -1;
        }

        if (array[currentRight] == value) {
            return 0;
        }

        while (currentRight < array.length - 1) {
            currentRight = Math.min(array.length - 1, currentRight + jumpLength);
            if (array[currentRight] >= value) {
                break;
            }
            previousRight = currentRight;
        }

        if ((currentRight == array.length - 1) && value > array[currentRight]) {
            return -1;
        }

        return backWardLinearSearch(array, value, previousRight, currentRight);
    }

    public static int backWardLinearSearch(int[] array, int value, int leftExcl, int rightIncl) {
        for (int i = rightIncl; i > leftExcl; i--) {
            if (array[i] == value) {
                return i;
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
