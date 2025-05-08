
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // brute force, TC: O(N^3), SC: O(N^3) in worst case but in practice O(number of unique triplets)
    // SC is bounded by O(N^3), its just the number of ways of picking three elements from the array n(n-1)(n-2)
    // static List<List<Integer>> threeSum(int[] nums, int m) {
    //     Set<List<Integer>> res = new HashSet<>();
    //     int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             for (int k = j + 1; k < n; k++) {
    //                 if (nums[i] + nums[j] + nums[k] == m) {
    //                     List<Integer> curr = Arrays.asList(nums[i], nums[j], nums[k]);
    //                     curr.sort(null);
    //                     res.add(curr);
    //                 }
    //             }
    //         }
    //     }
    //     return new ArrayList<>(res);
    // }

    // better approach, TC: O(N^2), SC: O(N^2), the hashset can take O(N) auxiliary space
    // public static List<List<Integer>> threeSum(int[] nums, int m) {
    //     Set<List<Integer>> res = new HashSet<>();
    //     int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         Set<Integer> set = new HashSet<>();
    //         for (int j = i + 1; j < n; j++) {
    //             int third = m - (nums[i] + nums[j]);
    //             if (set.contains(third)) {
    //                 List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
    //                 temp.sort(null);
    //                 res.add(temp);
    //             }
    //             set.add(nums[j]);
    //         }
    //     }
    //     return new ArrayList<>(res);
    // }

    // optimized approach, TC: O(NlogN + N^2), SC: O(N^2)
    public static List<List<Integer>> threeSum(int[] nums, int m) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < m) {
                    j++;
                } else if (sum > m) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int m = 0;
        System.out.println(threeSum(nums, m));
    }
}
