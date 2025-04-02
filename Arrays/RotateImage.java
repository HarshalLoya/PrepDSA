
public class RotateImage {

    static void printMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix1[j] + "\t");
            }
            System.out.println();
        }
    }

    // brute force approach, copy the elements to their correct position in another array and then copy all the elements back
    // TC: O(N^2), SC: O(N^2)
    // static void rotate(int[][] matrix) {
    //     int n = matrix.length;
    //     int[][] copy = new int[n][n];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             copy[i][j] = matrix[n - j - 1][i];
    //         }
    //     }
    //     for (int i = 0; i < n; i++) {
    //         System.arraycopy(copy[i], 0, matrix[i], 0, n);
    //     }
    // }

    // optimized approach, rotating in place, TC: O(N^2), SC: O(1)
    static void rotate(int[][] matrix) {
        int n = matrix.length;

        // transposing O(n/2 * n/2) time
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reversing the rows O(n * n/2) 
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("\nRotated Matrix");
        printMatrix(matrix);
    }
}
