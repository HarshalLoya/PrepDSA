
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // brute force approach, TC: O(N^2), SC: O(1)
    // public static boolean linearSearch(int[] nums, int k) {
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == k) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public static int longestConsecutive(int[] nums) {
    //     int n = nums.length, longest = 1;
    //     for (int i = 0; i < n; i++) {
    //         int x = nums[i];
    //         int count = 1;
    //         while (linearSearch(nums, x + 1) == true) {
    //             x++;
    //             count++;
    //         }
    //         longest = Math.max(longest, count);
    //     }
    //     return longest;
    // }
    
    // better approach, TC: O(NlogN), SC: O(1)
    // public static int longestConsecutive(int[] nums) {
    //     int n = nums.length;
    //     if (n == 0) {
    //         return 0;
    //     }
    //     Arrays.sort(nums);
    //     int largest = 1, lastmin = Integer.MIN_VALUE, count = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (nums[i] == lastmin + 1) {
    //             count++;
    //         } else {
    //             count = 1;
    //         }
    //         lastmin = nums[i];
    //         largest = Math.max(largest, count);
    //     }
    //     return Math.max(largest, count);
    // }

    // optimized approach, TC: O(N), SC: O(N)
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
