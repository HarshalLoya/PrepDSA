
import java.util.Arrays;

public class SortArrayOfZeroesOnesTwos {
    // brute force approach would be to just sort the array using a sorting algorithm in O(nlogn) TC

    // a better approach using O(N) TC, here we just find out the frequency of (0 1 2) and then fill the array accordingly
    // public static int[] sortArray(int[] nums) {
    //     int c0 = 0, c1 = 0, c2 = 0;
    //     for (int i : nums) {
    //         switch (i) {
    //             case 0 ->
    //                 c0++;
    //             case 1 ->
    //                 c1++;
    //             default ->
    //                 c2++;
    //         }
    //     }
    //     Arrays.fill(nums, 0, c0, 0);
    //     Arrays.fill(nums, c0, c0 + c1, 1);
    //     Arrays.fill(nums, c0 + c1, c0 + c1 + c2, 2);
    //     return nums;
    // }
    
    // optimal approach using Dutch National Flag Algorithm O(N) TC
    public static int[] sortArray(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0 -> {
                    // swap low and mid
                    int temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                }
                case 1 -> // just move mid forward
                    mid++;
                default -> {
                    // swap mid and high
                    int temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0};
        System.out.println(Arrays.toString(nums));
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
