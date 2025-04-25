
public class MedianOfTwoSortedArrays {

    // brute force approach, TC: O(M + N), TC: O(M + N)
    // static double findMedian(int[] a, int[] b) {
    //     int m = a.length, n = b.length;
    //     int[] merged = new int[m + n];
    //     int i = 0, j = 0, k = 0;
    //     while (i < m && j < n) {
    //         if (a[i] < b[j]) {
    //             merged[k++] = a[i++];
    //         } else {
    //             merged[k++] = b[j++];
    //         }
    //     }
    //     while (i < m) {
    //         merged[k++] = a[i++];
    //     }
    //     while (j < n) {
    //         merged[k++] = b[j++];
    //     }
    //     int l = merged.length;
    //     return l % 2 == 0 ? (double) (merged[l / 2 - 1] + merged[l / 2]) / 2 : merged[l / 2];
    // }

    // better approach, space optimized, TC: O(M + N), SC: O(1)
    // static double findMedian(int[] a, int[] b) {
    //     int m = a.length, n = b.length;
    //     int k = m + n;
    //     int i = 0, j = 0, cnt = 0, ind1 = k / 2, ind2 = ind1 - 1, ind1el = -1, ind2el = -1;
    //     while (i < m && j < n) {
    //         if (a[i] < b[j]) {
    //             if (cnt == ind1) {
    //                 ind1el = a[i];
    //             }
    //             if (cnt == ind2) {
    //                 ind2el = a[i];
    //             }
    //             cnt++;
    //             i++;
    //         } else {
    //             if (cnt == ind1) {
    //                 ind1el = b[j];
    //             }
    //             if (cnt == ind2) {
    //                 ind2el = b[j];
    //             }
    //             cnt++;
    //             j++;
    //         }
    //     }
    //     while (i < m) {
    //         if (cnt == ind1) {
    //             ind1el = a[i];
    //         }
    //         if (cnt == ind2) {
    //             ind2el = a[i];
    //         }
    //         cnt++;
    //         i++;
    //     }
    //     while (j < n) {
    //         if (cnt == ind1) {
    //             ind1el = b[j];
    //         }
    //         if (cnt == ind2) {
    //             ind2el = b[j];
    //         }
    //         cnt++;
    //         j++;
    //     }
    //     return k % 2 == 0 ? ind2el : (double) (ind2el + ind1el) / 2.0;
    // }

    // optimized approach with binary search, TC: O(log(M+N))
    static double findMedian(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (m + n + 1) / 2 - mid1;

            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2}, b = {3,4};
        double median = findMedian(a, b);
        System.out.println(median);
    }
}
