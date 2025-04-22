
public class CapacityToShipPackagesWithinDDays {

    // brute force approach, TC: O(N*(sum - max)), SC: O(1)
    // public static int shipWithinDays(int[] weights, int days) {
    //     int sum = 0, max = 0, n = weights.length;
    //     for (int weight : weights) {
    //         sum += weight;
    //         max = Math.max(max, weight);
    //     }
    //     for (int i = max; i <= sum; i++) {
    //         int d = 1, load = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (load + weights[j] > i) {
    //                 d++;
    //                 load = weights[j];
    //             } else {
    //                 load += weights[j];
    //             }
    //         }
    //         if (d <= days) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    
    // optimized approach, TC: O(N*log(sum - max)), SC: O(1)
    public static int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = 0;
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canShip(int[] weights, int capacity, int days) {
        int d = 1, load = 0;
        for (int w : weights) {
            if (load + w > capacity) {
                d++;
                load = w;
            } else {
                load += w;
            }
        }
        return d <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
