
import java.util.Arrays;

public class FrogJumpWithK {

    // memoization approach
    public static int solveMem(int k, int ind, int[] height, int[] dp) {
        if (ind == 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k && ind - i >= 0; i++) {
            int jump = solveMem(k, ind - i, height, dp) + Math.abs(height[ind] - height[ind - i]);
            ans = Math.min(ans, jump);
        }
        return dp[ind] = ans;
    }

    //tabular approach
    public static int solveTab(int k, int n, int[] height, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(height[i] - height[i - j]));
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int k = 5, height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(solveMem(k, n - 1, height, dp));
        System.out.println(solveTab(k, n, height, dp));
    }
}
