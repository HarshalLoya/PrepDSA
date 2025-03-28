
import java.util.Arrays;

public class RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        int n = arr.length;
        int[] ans = new int[n];
        // brute force TC: O(N + N/2)
        // int[] pos = new int[n / 2];
        // int[] neg = new int[n / 2];
        // int j = 0, k = 0;
        // for (int i = 0; i < n; i++) {
        //     if (arr[i] >= 0) {
        //         pos[j++] = arr[i];
        //     } else {
        //         neg[k++] = arr[i];
        //     }
        // }
        // for (int i = 0; i < pos.length; i++) {
        //     ans[2 * i] = pos[i];
        //     ans[2 * i + 1] = neg[i];
        // }

        // optimal TC: O(N)
        int pi = 0, ni = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                ans[pi] = arr[i];
                pi += 2;
            } else {
                ans[ni] = arr[i];
                ni += 2;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
