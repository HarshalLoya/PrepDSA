
import java.util.HashMap;

public class FibonacciDP {

    public static HashMap<Integer, Integer> dp = new HashMap<>();

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int result = fibo(n - 1) + fibo(n - 2);
        System.out.print(result + " ");
        dp.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        fibo(n);
    }

    // One more method using an array to keep track of previously computed values
    // public static int fibo(int n, int[] dp) {
    //     if (n <= 1) {
    //         return n;
    //     }
    //     if (dp[n] != -1) {
    //         return dp[n];
    //     }
    //     return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
    // }
    // public static void main(String[] args) {
    //     int n = 10;
    //     int[] dp = new int[n + 1];
    //     Arrays.fill(dp, -1);
    //     System.out.println(fibo(n, dp));
    // }
}
