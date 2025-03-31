
import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {

    // brute force approach, TC: O(N^2), SC: O(N)
    // public static void leaders(int[] nums, int n) {
    //     List<Integer> list = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         boolean isleader = true;
    //         for (int j = i; j < n; j++) {
    //             if (nums[j] > nums[i]) {
    //                 isleader = false;
    //             }
    //         }
    //         if (isleader) {
    //             list.add(nums[i]);
    //         }
    //     }
    //     System.out.println(list);
    // }

    // optimized approach, TC: O(N), SC: O(N)
    public static void leaders(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                list.add(max);
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        // both approach operate in O(N) SC if we ignore the list used to store the solutions
        int[] arr = {16, 17, 4, 3, 5, 2};
        int n = arr.length;
        leaders(arr, n);
    }
}
