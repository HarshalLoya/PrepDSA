
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    // brute force, C: O(N! * N), SC: O(N^2)
    // public static List<List<String>> solveNQueens(int n) {
    //     List<List<String>> solutions = new ArrayList<>();
    //     char[][] board = new char[n][n];
    //     for (int i = 0; i < n; i++) {
    //         Arrays.fill(board[i], '.');
    //     }
    //     solve(0, board, solutions, n);  
    //     return solutions;
    // }
    // private static void solve(int col, char[][] board, List<List<String>> solutions, int n) {
    //     if (col == n) {
    //         solutions.add(construct(board));
    //         return;
    //     }
    //     for (int row = 0; row < n; row++) {
    //         if (isSafe(row, col, board, n)) {
    //             board[row][col] = 'Q';
    //             solve(col + 1, board, solutions, n);
    //             board[row][col] = '.'; 
    //         }
    //     }
    // }
    // private static boolean isSafe(int row, int col, char[][] board, int n) {
    //     // same row on left side
    //     for (int j = 0; j < col; j++) {
    //         if (board[row][j] == 'Q') {
    //             return false;
    //         }
    //     }
    //     // upper-left diagonal
    //     for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
    //         if (board[i][j] == 'Q') {
    //             return false;
    //         }
    //     }
    //     // lower-left diagonal
    //     for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
    //         if (board[i][j] == 'Q') {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    // optimized approach TC: O(N!), SC: O(N^2 + N) => (board, boolean arrays)
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] rows = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];  // row + col
        boolean[] upperDiagonal = new boolean[2 * n - 1];  // n - 1 + col - row

        solve(0, board, results, rows, lowerDiagonal, upperDiagonal, n);
        return results;
    }

    private static void solve(int col, char[][] board, List<List<String>> results,
            boolean[] rows, boolean[] lowerDiagonal, boolean[] upperDiagonal, int n) {
        if (col == n) {
            results.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!rows[row] && !lowerDiagonal[row + col] && !upperDiagonal[n - 1 + col - row]) {
                board[row][col] = 'Q';
                rows[row] = lowerDiagonal[row + col] = upperDiagonal[n - 1 + col - row] = true;

                solve(col + 1, board, results, rows, lowerDiagonal, upperDiagonal, n);

                board[row][col] = '.';
                rows[row] = lowerDiagonal[row + col] = upperDiagonal[n - 1 + col - row] = false;
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> results = solveNQueens(n);
        for (List<String> solution : results) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
