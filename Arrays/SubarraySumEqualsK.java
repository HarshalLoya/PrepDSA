
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // brute force approach TC: O(N^2), SC: O(1)
    // if we use another loop to calculate the sum of the subarray from i->j, then the code runs in O(N^3) time
    // here we are just adding the current element to the sum instead of running a loop
    // public static int subarraySum(int[] nums, int k) {
    //     int n = nums.length, count = 0;
    //     for (int i = 0; i < n; i++) {
    //         int sum = 0;
    //         for (int j = i; j < n; j++) {
    //             sum += nums[j];
    //             if (sum == k) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // optimized approach, using the prefix sum approach, TC: O(N), SC: O(N)
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            if (prefixMap.containsKey(sum - k)) {
                count += prefixMap.get(sum - k);
            }
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }
        System.out.println(prefixMap);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }
}
