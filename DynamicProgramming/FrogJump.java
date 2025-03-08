
import java.util.Arrays;

public class FrogJump {

    // Memoization approach
    static int solveMem(int ind, int[] height, int[] dp) {
        if (ind == 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = solveMem(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
        if (ind > 1) {
            jumpTwo = solveMem(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
        }
        return dp[ind] = Math.min(jumpOne, jumpTwo);
    }

    // tabular appraoch
    public static int solveTab(int n, int[] height, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            if (i > 1) {
                jumpTwo = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }
            dp[i] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n - 1];
    }

    // space optimization approach
    public static int solveSpaceOpt(int n, int[] height) {
        int prev = 0;
        int prevPrev = 0;
        for (int i = 1; i < n; i++) {
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = prev + Math.abs(height[i] - height[i - 1]);
            if (i > 1) {
                jumpTwo = prevPrev + Math.abs(height[i] - height[i - 2]);
            }
            int curr = Math.min(jumpOne, jumpTwo);
            prevPrev = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(solveMem(n - 1, height, dp));
        System.out.println(solveTab(n, height, dp));
        System.out.println(solveSpaceOpt(n, height));
    }
}
