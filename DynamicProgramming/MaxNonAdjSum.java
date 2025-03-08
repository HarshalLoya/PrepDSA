
import java.util.Arrays;

public class MaxNonAdjSum {

    // memoization approach
    public static int maxSumMem(int ind, int[] nums, int[] dp) {
        if (ind == 0) {
            return nums[0];
        }
        if (ind < 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int incl = nums[ind] + maxSumMem(ind - 2, nums, dp);
        int excl = maxSumMem(ind - 1, nums, dp);
        dp[ind] = Math.max(incl, excl);
        return dp[ind];
    }

    // tabular approach
    public static int maxSumTab(int n, int[] nums, int[] dp) {
        for (int i = 0; i < n; i++) {
            switch (i) {
                case 0:
                    dp[i] = nums[i];
                    break;
                case 1:
                    dp[i] = Math.max(nums[i], dp[i - 1]);
                    break;
                default:
                    int incl = nums[i] + dp[i - 2];
                    int excl = dp[i - 1];
                    dp[i] = Math.max(incl, excl);
                    break;
            }
        }
        return dp[n - 1];
    }

    // space optimized method
    public static int maxSumSpaceOpt(int n, int[] nums) {
        int prev = nums[0];
        int prePrev = 0;

        for (int i = 1; i < n; i++) {
            int incl = nums[i];
            if (i > 1) {
                incl += prePrev;
            }
            int excl = prev;
            prePrev = excl;
            prev = Math.max(incl, excl);
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 3, 5, 8, 1, 9};
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(maxSumMem(n - 1, nums, dp));
        System.out.println(maxSumTab(n, nums, dp));
        System.out.println(maxSumSpaceOpt(n, nums));
    }
}

// if the houses are in a circle then
// this one takes a bit of more time
// class Solution {
//     static int solve(ArrayList<Integer> list) {
//         int n = list.size();
//         int prev = list.get(0);
//         int pprev = 0;
//         for (int i = 1; i < n; i++) {
//             int incl = list.get(i);
//             if (i > 1)
//                 incl += pprev;
//             int excl = prev;
//             pprev = prev;
//             prev = Math.max(incl, excl);
//         }
//         return prev;
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         ArrayList<Integer> arr1 = new ArrayList<>();
//         ArrayList<Integer> arr2 = new ArrayList<>();
//         if (n == 1)
//             return nums[0];
//         for (int i = 0; i < n; i++) {
//             if (i != 0)
//                 arr1.add(nums[i]);
//             if (i != n - 1)
//                 arr2.add(nums[i]);
//         }
//         int ans1 = solve(arr1);
//         int ans2 = solve(arr2);
//         return Math.max(ans1, ans2);
//     }
// }

// this one takes less time
// class Solution {

//     public int rob(int[] nums) {
//         if (nums.length == 1) {
//             return nums[0];
//         }
//         return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));
//     }

//     private int getMax(int[] nums, int start, int end) {
//         int prevRob = 0, maxRob = 0;

//         for (int i = start; i <= end; i++) {
//             int temp = Math.max(maxRob, prevRob + nums[i]);
//             prevRob = maxRob;
//             maxRob = temp;
//         }

//         return maxRob;
//     }
// }
