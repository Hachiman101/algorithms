package trees;

import java.util.NoSuchElementException;

public class BinaryHeap {
    private int size;
    private final int[] heap;

    public BinaryHeap(int maxsize) {
        this.size = 0;
        heap = new int[maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private void order(int position) {
        if (2 * position == size) {
            if (heap[position] > heap[2 * position]) {
                swap(position, 2 * position);
                order(2 * position);
            }
            return;
        }

        if (2 * position <= size) {
            if (heap[position] > heap[2 * position] || heap[position] > heap[2 * position + 1]) {
                if (heap[2 * position] < heap[2 * position + 1]) {
                    swap(position, 2 * position);
                    order(2 * position);
                } else {
                    swap(position, 2 * position + 1);
                    order(2 * position + 1);
                }
            }
        }
    }

    public void insert(int element) {
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[current / 2]) {
            swap(current, current / 2);
            current = current / 2;
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        int min = heap[1];
        heap[1] = heap[size--];
        order(1);
        return min;
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(20);
        binaryHeap.insert(20);
        binaryHeap.insert(54);
        binaryHeap.insert(2);
        binaryHeap.insert(94);
        binaryHeap.insert(19);
        binaryHeap.insert(7);
        binaryHeap.insert(13);
        binaryHeap.insert(21);
        binaryHeap.insert(62);
        binaryHeap.insert(37);
        binaryHeap.insert(38);
        binaryHeap.insert(75);
        System.out.println(binaryHeap.extractMin());
        System.out.println(binaryHeap.extractMin());
        System.out.println(binaryHeap.extractMin());
        System.out.println(binaryHeap.extractMin());
    }
}
