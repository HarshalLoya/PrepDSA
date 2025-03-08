
import java.util.Arrays;

public class LeftRotateByDPlaces {

    public static void rotateArray1(int[] arr, int d) {
        d %= arr.length;    // to handle cases when d > arr.length
        int[] temp = new int[d];
        System.arraycopy(arr, 0, temp, 0, d);
        // Manual array copy ⏬
        // for (int i = 0; i < d; i++) {
        //     temp[i] = arr[i];
        // }

        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        System.arraycopy(temp, 0, arr, d, d);
        // Manual copy again
        // for (int i = 0; i < d; i++) {
        //     arr[i + d] = temp[i];
        // }
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateArray2(int[] arr, int d) {
        int n = arr.length;
        d %= n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println("Array before rotating: " + Arrays.toString(arr));

        int d = 3;
        System.out.println("To be rotated by: " + d);

        // Suboptimal approach as it uses an extra array to store elements
        // rotateArray1(arr, d);
        // Optimal approach TC: O(n), SC: O(1)
        rotateArray2(arr, d);
        System.out.println("Array after rotating " + Arrays.toString(arr));
    }
}
