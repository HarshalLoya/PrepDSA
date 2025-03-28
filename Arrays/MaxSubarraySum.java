
import java.util.Arrays;

public class MaxSubarraySum {

    // better with TC: O(N^2), the brute force uses three for loops (itna ghatiya to mat hi sochna)
    // public static int maxSubarraySum(int[] arr) {
    //     int maxSum = Integer.MIN_VALUE, n = arr.length;
    //     int l = 0, r = 0;
    //     for (int i = 0; i < n; i++) {
    //         int curr = 0;
    //         for (int j = i; j < n; j++) {
    //             curr += arr[j];
    //             if (curr > maxSum) {
    //                 maxSum = curr;
    //                 l = i;
    //                 r = j;
    //             }
    //         }
    //     }
    //     int[] subarray = Arrays.copyOfRange(arr, l, r+1);
    //     System.out.println(Arrays.toString(subarray));
    //     return maxSum;
    // }
    
    // optimal, Kadane's algo TC: O(N)
    public static int maxSubarraySum(int[] arr) {
        int max = Integer.MIN_VALUE, sum = 0;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        int[] subarray = Arrays.copyOfRange(arr, start, end + 1);
        System.out.println(Arrays.toString(subarray));
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // [4, -1, 2, 1]
        System.out.println("Maximum contiguous sum is " + maxSubarraySum(arr));
    }
}
