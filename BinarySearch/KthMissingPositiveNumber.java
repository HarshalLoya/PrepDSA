
public class KthMissingPositiveNumber {

    // brute force solution, TC: O(N), SC: O(1)
    // public static int findKthPositive(int[] arr, int k) {
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i] <= k) {
    //             k++;
    //         } else {
    //             break;
    //         }
    //     }
    //     return k;
    // }
    
    // optimized solution, TC: O(log N), SC: O(1)
    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingCount = arr[mid] - mid - 1;
            if (missingCount < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // return arr[high] + more,
        // more = k - missingCount = k - arr[high] + high + 1
        // therefore return k + high + 1
        // at the end of the binary search low = high + 1
        // therefore we can return low + k
        return low + k;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 11};
        int k = 78;
        System.out.println(findKthPositive(arr, k));
    }
}
