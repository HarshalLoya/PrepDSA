
public class FindSquareRoot {

    // we have to find largest value of x such that x*x <= n using binary search 
    public static int findSqrt(int n) {
        if (n < 2) {
            return n;
        }
        int low = 1, high = n, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == n) {
                return mid; 
            }else if (square <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 978465579;
        System.out.println(findSqrt(n));
    }
}
