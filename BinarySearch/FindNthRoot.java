
public class FindNthRoot {

    //Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1

    // brute force approach, TC: O(N), SC: O(1)
    public static long power(int b, int exp) {
        // this is the power exponent function to find b^x in logn time instead of traditional n time
        long ans = 1, base = b;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = ans * base;
            }
            base = base * base;
            exp >>= 1;

        }
        return ans;
    }

    // public static double findNthRoot(int N, int M) {
    //     for (int i = 0; i <= M; i++) {
    //         long val = power(i, N);
    //         if (val == (long) M) {
    //             return i;
    //         } else if (val > (long) M) {
    //             break;
    //         }
    //     }
    //     return -1;
    // }

    // Optimized solution: TC: O(logN), SC: O(1)
    public static int findNthRoot(int N, int M) {
        if (N <= 0) {
            throw new IllegalArgumentException("n must be greater than 0.");
        }
        if (M == 0) {
            return 0;
        }
        if (M < 0) {
            if (N % 2 == 0) {
                return -1;
            } else {
                int posRoot = findNthRoot(N, -M);
                return posRoot == -1 ? -1 : -posRoot;
            }
        }
        int low = 1, high = M;
        while (low <= high) {
            int mid = (low + high) / 2;
            long val = power(mid, N);
            if (val == (long) M) {
                return mid;
            } else if (val < (long) M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        // Positive m examples
        System.out.println("3rd root of 27 is: " + findNthRoot(3, 27)); // Expected output: 3
        System.out.println("2nd root of 16 is: " + findNthRoot(2, 16)); // Expected output: 4
        System.out.println("2nd root of 10 is: " + findNthRoot(2, 10)); // Expected output: -1

        // Edge case: m = 0
        System.out.println("2nd root of 0 is: " + findNthRoot(2, 0));   // Expected output: 0

        // Negative m, odd exponent
        System.out.println("3rd root of -27 is: " + findNthRoot(3, -27)); // Expected output: -3

        // Negative m, even exponent
        System.out.println("2nd root of -16 is: " + findNthRoot(2, -16)); // Expected output: -1
    }
}
