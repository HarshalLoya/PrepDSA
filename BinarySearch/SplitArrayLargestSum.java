/*Problem Statement: Given an integer array 'nums' of size 'n' and an integer 'm'. Split the array 'nums' into 'm' non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.*/
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class SplitArrayLargestSum {

    public static int countPartitions(int[] nums, int maxSum) {
        int partitions = 1, subarraysum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (subarraysum + nums[i] > maxSum) {
                partitions++;
                subarraysum = nums[i];
            } else {
                subarraysum += nums[i];
            }
        }
        return partitions;
    }

    // brute force approach, TC: O(N*(sum - max)), SC: O(1)
    // public static int splitArray(int[] nums, int m) {
    //     if (m > nums.length) {
    //         return -1;
    //     }
    //     IntSummaryStatistics stats = Arrays.stream(nums).summaryStatistics();
    //     int max = (int) stats.getMax(), sum = (int) stats.getSum();
    //     for (int i = max; i <= sum; i++) {
    //         if (countPartitions(nums, i) == m) {
    //             return i;
    //         }
    //     }
    //     return max;
    // }
    
    // optimized approach using binary search, TC: O(N*log(sum - max)), SC: O(1)
    public static int splitArray(int[] nums, int m) {
        IntSummaryStatistics stats = Arrays.stream(nums).summaryStatistics();
        int low = (int) stats.getMax(), high = (int) stats.getSum();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(countPartitions(nums, mid) > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;
        int result = splitArray(nums, m);
        System.out.println("The minimum largest sum is: " + result);
    }
}
