
import java.util.Arrays;

public class OccursOnce {

    public static int findElement(int[] arr) {
        int n = arr.length;

        // brute force O(N^2)
        // int ans = -1;
        // for (int i = 0; i < n; i++) {
        //     int count = 0;
        //     for (int j = 0; j < n; j++) {
        //         if (arr[i] == arr[j]) {
        //             count++;
        //         }
        //     }
        //     if (count == 1) {
        //         ans = arr[i];
        //         break;
        //     }
        // }
        // return ans;
        
        // improved using a hashset O(N)
        // HashSet<Integer> hs = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     if (hs.contains(arr[i])) {
        //         hs.remove(arr[i]);
        //     } else {
        //         hs.add(arr[i]);
        //     }
        // }
        // return hs.iterator().next();

        // also an O(N) approach, but with O(1) SC
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr ^= arr[i];
        }
        return xorr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 2, 2, 4, 5, 6, 7, 6, 7};
        System.out.println(Arrays.toString(arr));
        System.out.println("Element occuring only once is: " + findElement(arr));
    }
}
