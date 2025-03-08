
import java.util.Arrays;

public class MoveZeroesToEnd {

    public static void moveZeroesToEnd(int[] nums) {
        // Brute force
        // int count = 0;
        // for (int i : nums) {
        //     if (i == 0) {
        //         count++;
        //     }
        // }
        // int[] temp = new int[nums.length - count];
        // int j = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         temp[j] = nums[i];
        //         j++;
        //     }
        // }
        // System.arraycopy(temp, 0, nums, 0, temp.length);
        // Arrays.fill(nums, temp.length, nums.length, 0);

        // Optimal approach, O(n) TC
        int j = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return;
        }
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 5, 0, 3, 0, 1, 0, 4};
        System.out.println(Arrays.toString(nums));
        moveZeroesToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }
}
