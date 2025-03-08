
public class MajorityElement {

    // brute force TC: O(N^2), SC: O(1)
    // public static int majorityElement(int[] nums) {
    //     int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         int count = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (nums[i] == nums[j]) {
    //                 count++;
    //             }
    //         }
    //         if (count > n / 2) {
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }
    
    // better approach using a hashmap TC & SC: O(N)
    // public static int majorityElement(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         map.put(nums[i], (map.getOrDefault(nums[i], 0) + 1));
    //         if (map.get(nums[i]) > n / 2) {
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }

    // optimal approach TC: O(N), SC: O(1)
    public static int majorityElement(int[] nums) {
        int count = 0, candidate = -1;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            count += (i == candidate) ? 1 : -1;
        }
        int cnt = 0;
        // rechecking if the candidate is actually the majority element or not
        for (int i : nums) {
            if (i == candidate) {
                cnt++;
            }
        }
        return cnt > nums.length / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 1, 2, 2};
        int result = majorityElement(nums);
        System.out.println(result);
    }
}
