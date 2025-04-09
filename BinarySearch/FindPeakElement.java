
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPeakElement {

    // brute force approach, TC: O(N), SC: O(1)
    // public static int[] findPeakElement(int[] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         if ((i == 0 || nums[i - 1] < nums[i]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
    //             return new int[] {i};
    //         }
    //     }
    //     return new int[] {-1};
    // }

    // optimized appraoch, TC: O(logN), SC: O(1)
    // this approach will work in case of multiple peaks too
    // public static int[] findPeakElement(int[] nums) {
    //     int n = nums.length;
    //     if (n == 1 || nums[0] > nums[1]) {
    //         return new int[] {0};
    //     }
    //     if (nums[n - 1] > nums[n - 2]) {
    //         return new int[] {n - 1};
    //     }
    //     int left = 1, right = n - 2;
    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;
    //         if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
    //             return new int[] {mid};
    //         } else if (nums[mid] < nums[mid + 1]) {
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //     }
    //     return new int[] {-1};
    // }

    // if we are required to return all the peak we have to use linear search
    public static int[] findPeakElement(int[] nums) {
        int n = nums.length;
        List<Integer> peaks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i == 0 && n > 1 && nums[i] > nums[i + 1])  // checks for first index
                    || (i == n - 1 && n > 1 && nums[i] > nums[i - 1])   // checks for last index
                    || (i > 0 && i < n - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1])   // checks for any other index in middle
                    || (n == 1)) {  // in case nus.length == 1
                peaks.add(i);
            }
        }

        return peaks.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 1, 5, 3};
        System.out.println(Arrays.toString(findPeakElement(nums)));
    }
}
