
import java.util.Arrays;

public class MinimumNumberOfPlatforms {

    // brute force, TC: O(N^2), SC: O(1)
    // public static int countPlatforms(int[] arr, int[] dep, int n) {
    //     int platforms = 1;
    //     for (int i = 0; i < n; i++) {
    //         int count = 1;
    //         for (int j = i + 1; j < n; j++) {
    //             if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])) {
    //                 count++;
    //             }
    //             platforms = Math.max(platforms, count);
    //         }
    //     }
    //     return platforms;
    // }

    // optimized appraoch, TC: O(2 * NLogN) + O(N) => (sorting, traversing), SC: O(1)
    public static int countPlatforms(int[] arr, int[] dep, int n) {
        int platforms = 1;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0, count = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            platforms = Math.max(platforms, count);
        }

        return platforms;
    }

    public static void main(String[] args) {
        int arr[] = {900, 945, 955, 1100, 1500, 1800};
        int dep[] = {920, 1200, 1130, 1150, 1900, 2000};
        System.out.println(countPlatforms(arr, dep, arr.length));
    }
}
