
public class FindMinimumInRotatedSortedArray {

    // approach 1
    // public static int findMin(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     int left = 0, right = nums.length - 1;
    //     while (left < right) {
    //         int mid = left + (right - left) / 2;
    //         if (nums[mid] > nums[right]) {
    //             left = mid + 1;
    //         } else {
    //             right = mid;
    //         }
    //     }
    //     return nums[left];
    // }
    
    // approach 2
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        // a little more optimization if the array is not rotated
        if(nums[left] < nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= nums[left]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            } else {
                ans = Math.min(ans, nums[right]);
                right = mid;
            }
            System.out.printf("MID: %d, ANS: %d, LEFT: %d, RIGHT: %d%n", mid, ans, left, right);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }
}
