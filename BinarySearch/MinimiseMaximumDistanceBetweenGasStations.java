
public class MinimiseMaximumDistanceBetweenGasStations {

    // brute force approach, TC: O(K*N), SC: O(N-1)
    // static double minimiseDistance(int[] arr, int k) {
    //     int n = arr.length;
    //     int[] howMany = new int[n - 1];
    //     for (int stations = 1; stations <= k; stations++) {
    //         double maxSection = -1;
    //         int maxInd = -1;
    //         for (int i = 0; i < n - 1; i++) {
    //             double diff = arr[i + 1] - arr[i];
    //             double sectionLength = diff / (double) (howMany[i] + 1);
    //             if (sectionLength > maxSection) {
    //                 maxSection = sectionLength;
    //                 maxInd = i;
    //             }
    //         }
    //         howMany[maxInd]++;
    //     }
    //     double max = -1;
    //     for (int i = 0; i < n - 1; i++) {
    //         double diff = arr[i + 1] - arr[i];
    //         double sectionLength = diff / (double) (howMany[i] + 1);
    //         max = Math.max(max, sectionLength);
    //     }
    //     return max;
    // }
    
    // better approach, using priority queue, TC: O(NlogN + KlogN), SC: O(N-1) + O(N-1)
    // static class Pair {
    //     double first;
    //     int second;
    //     Pair(double first, int second) {
    //         this.first = first;
    //         this.second = second;
    //     }
    // }
    // static double minimiseDistance(int[] arr, int k) {
    //     int n = arr.length;
    //     int[] howMany = new int[n - 1];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
    //     for (int i = 0; i < n - 1; i++) {
    //         pq.add(new Pair(arr[i + 1] - arr[i], i));
    //     }
    //     for (int stations = 1; stations <= k; stations++) {
    //         Pair tp = pq.poll();
    //         int secInd = tp.second;
    //         howMany[secInd]++;
    //         double inidiff = arr[secInd + 1] - arr[secInd];
    //         double newSecLen = inidiff / (double) (howMany[secInd] + 1);
    //         pq.add(new Pair(newSecLen, secInd));
    //     }
    //     return pq.peek().first;
    // }

    // optimal approach using binary search, TC: O(N*log(Len)) + O(N), N = size of the given array, Len = length of the answer space, SC: O(1)
    static int numberOfStations(int[] arr, double mid, int n) {
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / mid);
            if ((arr[i] - arr[i - 1]) == (mid * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    static double minimiseDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0, high = 0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double) (arr[i + 1] - arr[i]));
        }

        double diff = 10e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int cnt = numberOfStations(arr, mid, n);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = minimiseDistance(arr, k);
        System.out.println(ans);
    }
}
