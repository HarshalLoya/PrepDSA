import java.util.Arrays;

public class ClimbingStairs {
    public static int stairs(int n, int[] dp){
        if(n <= 0) return 1;
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = stairs(n-1, dp) + stairs(n-2, dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(stairs(n, dp));
    }
}
