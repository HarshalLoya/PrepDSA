
import java.util.Arrays;

public class IsArraySorted {

    public static boolean isSorted(int[] arr) {
        if (arr.length < 1) {
            return false;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 11};
        System.out.println(Arrays.toString(arr));
        System.out.println(isSorted(arr)); // prints: true
    }
}
