

public class KokoEatingBananas {

    // brute force method, TC: O(MAX*N), TC: O(1)
    // public static int minEatingSpeed(int[] piles, int h) {
    //     int n = piles.length;
    //     int low = 1, high = Arrays.stream(piles).max().getAsInt();
    //     for (int i = low; i <= high; i++) {
    //         int time = 0;
    //         for (int j = 0; j < n; j++) {
    //             time += Math.ceil(piles[j] / (double) i);
    //         }
    //         if (time > h) {
    //             low = i + 1;
    //         }
    //     }
    //     return low;
    // }

    // optimized approach binary search method, TC: O(N*log(MAX)), SC: O(1)
    // public static int minEatingSpeed(int[] piles, int h) {
    //     int n = piles.length;
    //     int low = 1, high = Arrays.stream(piles).max().getAsInt();
    //     while (low < high) {
    //         int mid = low + (high - low) / 2;
    //         int time = 0;
    //         for (int j = 0; j < n; j++) {
    //             time += Math.ceil(piles[j] / (double) mid);
    //         }
    //         if (time > h) {
    //             low = mid + 1;
    //         } else {
    //             high = mid;
    //         }
    //     }
    //     return low;
    // }
    
    // another optimized approach that ran in less time than the above one
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for (int p : piles) {
            total += p;
        }
        int low = (int) ((total - 1) / h) + 1;
        int high = (int) ((total - n) / (h - n + 1)) + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mid + 1;
            }
            if (time > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
