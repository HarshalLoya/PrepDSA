
public class MinimumNumberOfDaysToMakeMBouquets {

    // brute force approach, TC: O((MAX - MIN + 1)*N), SC: O(1)
    // public static int minDays(int[] bouquets, int m, int k) {
    //     if (m * k > bouquets.length) {
    //         return -1;
    //     }
    //     int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    //     for (int i : bouquets) {
    //         max = Math.max(max, i);
    //         min = Math.min(min, i);
    //     }
    //     for (int i = min; i <= max; i++) {
    //         int count = 0, bouquet = 0;
    //         for (int j : bouquets) {
    //             if (i >= j) {
    //                 count++;
    //             } else {
    //                 bouquet += count/k;
    //                 count = 0;
    //             }
    //         }
    //         if (count > 0) {
    //             bouquet += count/k;
    //         }
    //         if (bouquet >= m) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    
    // optimized approahc using binary search, TC: O(N * log(MAX - MIN)), SC: O(1)
    public static int minDays(int[] bloomDay, int m, int k) {
        if (((long) m * k) > bloomDay.length) {
            return -1;
        }
        int max = 0, min = Integer.MAX_VALUE;
        for (int i : bloomDay) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int left = min, right = max, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int flowers = 0, bouquets = 0;
            for (int j : bloomDay) {
                if (mid >= j) {
                    if (++flowers == k) {
                        bouquets++;
                        flowers = 0;
                        if (bouquets == m) {
                            break;
                        }
                    }
                } else {
                    flowers = 0;
                }
            }
            if (bouquets >= m) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] bloomDay = {7, 7, 7, 7, 13, 12, 7, 7};
        int m = 2;
        int k = 3;
        System.out.println(minDays(bloomDay, m, k));
    }
}
