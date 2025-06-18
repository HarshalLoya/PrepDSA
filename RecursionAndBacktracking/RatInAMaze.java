
import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static List<String> findPaths(int[][] maze) {
        int n = maze.length;
        List<String> paths = new ArrayList<>();

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return paths;   // start or end is blocked
        }

        boolean[][] visited = new boolean[n][n];
        backtrack(maze, 0, 0, "", visited, paths);

        return paths;
    }

    private static void backtrack(int[][] maze, int i, int j, String path, boolean[][] visited, List<String> paths) {
        int n = maze.length;

        if (i == n - 1 && j == n - 1) {
            paths.add(path);
            return;
        }

        // Mark current cell
        visited[i][j] = true;

        // Lexicographical direction order: D, L, R, U
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d], nj = j + dy[d];

            if (isSafe(ni, nj, maze, visited)) {
                backtrack(maze, ni, nj, path + dir[d], visited, paths);
            }
        }

        // Backtrack
        visited[i][j] = false;
    }

    private static boolean isSafe(int i, int j, int[][] maze, boolean[][] visited) {
        int n = maze.length;
        return i >= 0 && j >= 0 && i < n && j < n && maze[i][j] == 1 && !visited[i][j];
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        List<String> solutions = findPaths(maze);   // moves => {D,L,R,U}
        for (String solution : solutions) {
            System.out.println(solution);
        }
    }
}
