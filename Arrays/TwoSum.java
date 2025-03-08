
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // brute force method TC: O(N^2)
    // public static boolean doesSumExist(int[] nums, int target) {
    //     int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             if (nums[i] + nums[j] == target) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    
    // better method, TC: O(N)
    public static boolean doesSumExist(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(target - nums[i])) {
                return true;
            }
            list.add(nums[i]);
        }
        return false;
    }

    public static int[] getIndexesIfSumExists(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mpp.containsKey(target - nums[i])) {
                return new int[]{mpp.get(target - nums[i]), i};
            }
            mpp.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int nums[] = {2, 6, 5, 8, 11}, target = 14;
        if (doesSumExist(nums, target)) {
            System.out.println("Sum exists");
            System.out.println(Arrays.toString(getIndexesIfSumExists(nums, target)));
        } else {
            System.out.println("Sum does not exist");
        }
    }
}
