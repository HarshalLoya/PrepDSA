
import java.util.Arrays;

public class ReverseAnArray {
    public static int[] reverse(int[] a, int low, int high){
        if(low >= high){
            return a;
        }
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
        return reverse(a, low + 1, high - 1);
    }
    public static void main(String[] args) {
        // reverse the given array using recursion
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int low = 0, high = a.length - 1;
        reverse(a, low, high);
        System.out.println(Arrays.toString(a));
    }
}
