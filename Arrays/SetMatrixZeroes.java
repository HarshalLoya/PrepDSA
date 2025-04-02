
public class SetMatrixZeroes {

    static void printMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix1[j] + "\t");
            }
            System.out.println();
        }
    }

    // brute force approach TC: O(m×n×(m+n)) + O(m*n), SC: O(1)
    // static void setZeroes(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     // marking the positions
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == 0) {
    //                 for (int k = 0; k < m; k++) {
    //                     if (matrix[k][j] != 0) {
    //                         matrix[k][j] = -1;
    //                     }
    //                 }
    //                 for (int k = 0; k < n; k++) {
    //                     if (matrix[i][k] != 0) {
    //                         matrix[i][k] = -1;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     // setting the marked positions to 0
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == -1) {
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }

    // better approach TC: O(m*n), SC: O(m + n)
    // static void setZeroes(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int[] row = new int[m], col = new int[n];
    //     // identifying the rows and columns with zeroes
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == 0) {
    //                 row[i] = 1;
    //                 col[j] = 1;
    //             }
    //         }
    //     }
    //     // marking the rows and columns with zeros, both can take, in worst case O(m*n) time
    //     for (int i = 0; i < m; i++) {
    //         if (row[i] == 1) {
    //             for (int j = 0; j < n; j++) {
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    //     for (int i = 0; i < n; i++) {
    //         if (col[i] == 1) {
    //             for (int j = 0; j < m; j++) {
    //                 matrix[j][i] = 0;
    //             }
    //         }
    //     }
    // }

    // optimized approach, TC: O(m*n), SC: O(1)
    static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        // checking first row and columns for zeroes, O(m+n) time
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
            }
        }
        // marking rows and columns using first row and column, O(m*n) time
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // setting zeroes in rows and columns, O(m*n)
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // setting zeroes in first row and column, O(m+n)
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 0},
            {13, 14, 15, 16}
        };
        System.out.println("Original Matrix:");
        // System.out.println(Arrays.deepToString(matrix));
        printMatrix(matrix);
        setZeroes(matrix);
        System.out.println("\nMatrix after setting zeroes:");
        // System.out.println(Arrays.deepToString(matrix));
        printMatrix(matrix);
    }
}
