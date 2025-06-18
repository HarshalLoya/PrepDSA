
public class MatrixMedian {

    // brute force approach TC: O(Tlog(T)), SC: O(T), T = M*N
    // public static int median(int[][] matrix, int m, int n) {
    //     int[] arr = new int[m * n];
    //     int ind = 0;
    //     for (int[] row : matrix) {
    //         for (int i : row) {
    //             arr[ind++] = i;
    //         }
    //     }
    //     Arrays.sort(arr);
    //     return arr[m * n / 2];
    // }
    
    // optimized approach TC: O(log(range) * MlogN), SC: O(1), range = matMax - matMin
    public static int median(int[][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int desired = m * n / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int i = 0; i < m; i++) {
                count += countLessOrEqual(matrix[i], mid, n);
            }

            if (count <= desired) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countLessOrEqual(int[] row, int k, int n) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {8, 9, 11, 12, 13},
            {21, 23, 25, 27, 29}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = median(matrix, m, n);
        System.out.println("The median element is: " + ans);
    }
}
