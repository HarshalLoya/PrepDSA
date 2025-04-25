
public class KthElementOfTwoSortedArrays {

    static int findKthElement(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) {
            return findKthElement(nums2, nums1, k);
        }
        int low = Math.max(k - n2, 0), high = Math.min(k, n1);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;

            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } // eliminate the halves:
            else if (l1 > r2) {
                high = mid1 - 1; 
            }else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 7, 9}, nums2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(findKthElement(nums1, nums2, k));
    }
}
