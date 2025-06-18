
import java.util.Arrays;

public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public MaxHeap(int[] arr) {
        heap = Arrays.copyOf(arr, arr.length);
        size = arr.length;
        for (int i = parent(size - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return size;
    }

    public void insert(int val) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = val;
        siftUp(size);
        size++;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public int extract() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return root;
    }

    private void siftUp(int idx) {
        int p = parent(idx);
        while (idx > 0 && heap[idx] > heap[p]) {
            swap(idx, p);
            idx = p;
            p = parent(idx);
        }
    }

    private void siftDown(int idx) {
        while (true) {
            int left = leftChild(idx);
            int right = rightChild(idx);
            int largest = idx;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest == idx) {
                break;
            }
            swap(idx, largest);
            idx = largest;
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    // simple test
    public static void main(String[] args) {
        int[] data = {5, 3, 8, 1, 2, 9, 7};
        System.out.println("Testing MaxHeap");
        MaxHeap heap = new MaxHeap(data);
        System.out.println("Built, top = " + heap.peek());
        System.out.print("Extracting: ");
        while (heap.size() > 0) {
            System.out.print(heap.extract() + " ");
        }
        System.out.println();
    }
}
