
public class TrappingRainWater {

    // better force approach, TC: O(3N), SC: O(2N), the brute approach, TC: O(N^2), SC: O(1)
    // public static int trap(int[] height) {
    //     int n = height.length;
    //     int[] preMax = new int[n];
    //     int[] sufMax = new int[n];
    //     preMax[0] = height[0];
    //     sufMax[n - 1] = height[n - 1];
    //     for (int i = 1; i < n; i++) {
    //         preMax[i] = Math.max(preMax[i - 1], height[i]);
    //     }
    //     for (int i = n - 2; i > -1; i--) {
    //         sufMax[i] = Math.max(sufMax[i + 1], height[i]);
    //     }
    //     int trapped = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (preMax[i] > height[i] && sufMax[i] > height[i]) {
    //             trapped += Math.min(preMax[i], sufMax[i]) - height[i];
    //         }
    //     }
    //     return trapped;
    // }
    
    // optimized approach, TC: O(N), SC: O(1)
    public static int trap(int[] height) {
        int n = height.length;
        int trapped = 0;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {                               // if (height[left] < height[right]) {
                    leftMax = height[left];                                 //     leftMax = Math.max(leftMax, height[left]);
                } else {                                                    //     ans += leftMax - height[left++];
                    trapped += leftMax - height[left];                      // } else {
                }                                                           //     rightMax = Math.max(rightMax, height[right]);
                left++;                                                     //     ans += rightMax - height[right--];
            } else {                                                        //  }
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    trapped += rightMax - height[right];
                }
                right--;
            }
        }
        return trapped;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
