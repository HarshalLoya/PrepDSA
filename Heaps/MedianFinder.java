
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
// Normal Implementation, O(logN) insertions and O(1) to find Median, SC: O(N), storing N elements in two different heaps

    private final PriorityQueue<Integer> lower;   // max heap for the lower half
    private final PriorityQueue<Integer> higher;  // min heap for the upper half
    public MedianFinder() {
        lower = new PriorityQueue<>(Collections.reverseOrder());
        higher = new PriorityQueue<>();
    }
    public void addNum(int num) {
        // add to appropriate heap
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.offer(num);
        } else {
            higher.offer(num);
        }
        // balance sizes: allow lower to have at most one more element
        if (lower.size() > higher.size() + 1) {
            higher.offer(lower.poll());
        } else if (higher.size() > lower.size()) {
            lower.offer(higher.poll());
        }
    }
    public double findMedian() {
        if (lower.size() > higher.size()) {
            return lower.peek();
        }
        return (lower.peek() + higher.peek()) / 2.0;
    }

// Follow up 1: all values in [0...100]
    // private final int[] freq = new int[101];
    // private int total = 0;
    // public void addNum(int num) {
    //     if (num < 0 || num > 100) {
    //         throw new IllegalArgumentException("Value out of [0, 100]");
    //     }
    //     freq[num]++;
    //     total++;
    // }
    // public double findMedian() {
    //     if (total == 0) {
    //         throw new IllegalStateException("No elements added");
    //     }
    //     int mid1 = (total + 1) / 2;
    //     int mid2 = (total % 2 == 1) ? mid1 : mid1 + 1;
    //     int count = 0, val1 = -1, val2 = -1;
    //     for (int v = 0; v <= 100; v++) {
    //         count += freq[v];
    //         if (val1 < 0 && count >= mid1) {
    //             val1 = v;
    //         }
    //         if (count >= mid2) {
    //             val2 = v;
    //             break;
    //         }
    //     }
    //     return (val1 + val2) / 2.0;
    // }

// Follow up 2: 99% values in [0...100], rare outliers
    // private final int[] freq = new int[101];
    // private final List<Integer> lowerOutliers = new ArrayList<>();
    // private final List<Integer> higherOutliers = new ArrayList<>();
    // private int totalBulk = 0;

    // public void addNum(int num) {
    //     if (0 <= num && num <= 100) {
    //         freq[num]++;
    //         totalBulk++;
    //     } else if (num < 0) {
    //         lowerOutliers.add(num);
    //     } else {
    //         higherOutliers.add(num);
    //     }
    // }

    // public double findMedian() {
    //     int total = totalBulk + lowerOutliers.size() + higherOutliers.size();
    //     if (total == 0) {
    //         throw new IllegalStateException("No elements added");
    //     }
    //     int k1 = (total + 1) / 2;
    //     int k2 = (total % 2 == 1) ? k1 : k1 + 1;
    //     return (findKth(k1) + findKth(k2)) / 2.0;
    // }

    // private int findKth(int k) {
    //     int sizeLow = lowerOutliers.size();
    //     if (k <= sizeLow) {
    //         Collections.sort(lowerOutliers);
    //         return lowerOutliers.get(k - 1);
    //     }

    //     int kInBulk = k - sizeLow;
    //     if (kInBulk <= totalBulk) {
    //         int count = 0;
    //         for (int v = 0; v <= 100; v++) {
    //             count += freq[v];
    //             if (count >= kInBulk) {
    //                 return v;
    //             }
    //         }
    //     }

    //     int kInHigh = k - totalBulk - sizeLow;
    //     Collections.sort(higherOutliers);
    //     return higherOutliers.get(kInHigh - 1);
    // }

    public static void main(String[] args) {
        String[] operations = {
            "MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian",
            "addNum", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian"
        };

        int[][] arguments = {
            {}, {5}, {15}, {}, {1}, {},
            {3}, {8}, {}, {7}, {}, {9}, {}
        };

        MedianFinder obj = null;
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MedianFinder" -> {
                    obj = new MedianFinder();
                    System.out.println("MedianFinder initialized.");
                }
                case "addNum" -> {
                    obj.addNum(arguments[i][0]);
                    System.out.println("addNum(" + arguments[i][0] + ")");
                }
                case "findMedian" -> {
                    double median = obj.findMedian();
                    System.out.println("findMedian() -> " + median);
                }
            }
        }
    }
}
