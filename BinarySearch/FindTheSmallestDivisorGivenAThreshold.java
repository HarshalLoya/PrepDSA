

public class FindTheSmallestDivisorGivenAThreshold {

    // brute force approach, TC: O(MAX*N), SC: O(1)
    // public static int findSmallestDivisor(int[] nums, int threshold) {
    //     int n = nums.length;
    //     int max = Arrays.stream(nums).max().getAsInt();
    //     if (threshold == n) {
    //         return max;
    //     }
    //     for (int i = 1; i <= max; i++) {
    //         int sum = 0;
    //         for (int j : nums) {
    //             sum += Math.ceil((double) j / i);
    //         }
    //         if (sum <= threshold) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // optimal approach using binary search, TC: O(N*log(MAX)), SC: O(1)
    // public static int findSmallestDivisor(int[] nums, int threshold) {
    //     int n = nums.length;
    //     int max = Arrays.stream(nums).max().getAsInt();
    //     if (threshold == n) {
    //         return max;
    //     }
    //     int left = 1, right = max;
    //     while (left < right) {
    //         int mid = left + (right - left) / 2;
    //         int sum = 0;
    //         for (int j : nums) {
    //             sum += (int) Math.ceil((double) j / mid);
    //         }
    //         if (sum <= threshold) {
    //             right = mid;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     return left;
    // }

    // using the constraints to our advantage, reduces the constant time factor quite a bit
    public static int findSmallestDivisor(int[] nums, int threshold) {
        long sum = 0;
        int max = 0;
        for (int x : nums) {
            sum += x;
            if (x > max) {
                max = x;
            }
        }
        // 1) trivial: if sum ≤ threshold, divisor = 1
        if (sum <= threshold) {
            return 1;
        }

        // 2) lower bound = ceil(sum/threshold)
        int low = (int) ((sum + threshold - 1) / threshold);
        int high = max;
        int answer = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long s = 0;
            // 3) compute total with early exit
            for (int x : nums) {
                s += (x + mid - 1) / mid;
                if (s > threshold) {
                    break;
                }
            }
            if (s <= threshold) {
                answer = mid;
                high = mid - 1;    // try smaller divisor
            } else {
                low = mid + 1;     // need a larger divisor
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {12, 22, 33, 11, 1};
        int threshold = 6;
        int smallestDivisor = findSmallestDivisor(nums, threshold);
        System.out.println(smallestDivisor);
    }
}
