
import java.util.Arrays;

public class HeapSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        // building max heap
        for (int i = parent(n - 1); i >= 0; i--) {
            siftDown(arr, i, n);
        }

        // extract elements form heap one by one
        for (int end = n - 1; end >= 0; end--) {
            // move current max to the end
            swap(arr, 0, end);
            // restore heap property on reduced heap
            siftDown(arr, 0, end);
        }
    }

    private static void siftDown(int[] arr, int i, int heapSize) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < heapSize && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest == i) {
                break;
            }
            swap(arr, i, largest);
            i = largest;
        }
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {12, 3, 17, 8, 34, 1, 9, 27};
        System.out.println("Before sort: ");
        System.out.println(Arrays.toString(data));

        sort(data);

        System.out.println("After sort: ");
        System.out.println(Arrays.toString(data));
    }
}
