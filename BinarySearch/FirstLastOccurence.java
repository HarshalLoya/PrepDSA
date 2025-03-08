
public class FirstLastOccurence {

    public static int lowerBound(int []arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {2, 4, 6, 8, 8, 11, 13}, target = 8;
        int n = nums.length;
        int lb = lowerBound(nums, target, n);
        if (lb == n || nums[lb] != target) {
            System.out.println("-1 -1");
        } else {
            System.out.println(lb + " " + (upperBound(nums, target, n) - 1));
        }
    }
}
