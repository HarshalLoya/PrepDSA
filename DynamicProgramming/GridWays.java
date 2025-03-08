public class GridWays { 

    public int ways(int row, int col, int i, int j) {
        if (row == i - 1 && col == j - 1) {
            return 1;
        } else if (i == row || j == col) {
            return 0;
        }

        int right = ways(row + 1, col, i, j);
        int down = ways(row, col + 1, i, j);

        return right + down;
    }

    public static void main(String[] args) {
        int n = 20, m = 14;
        GridWays obj = new GridWays();

        long start = System.nanoTime(); // Start time

        int result = obj.ways(0, 0, n, m);
        System.out.println("Ways: " + result);

        long end = System.nanoTime(); // End time

        long timeTaken = end - start; // Time in nanoseconds
        System.out.println("Time taken: " + timeTaken + " nanoseconds");
        System.out.println("Time taken: " + (timeTaken / 1_000_000.0) + " milliseconds");
        System.out.println("Time taken: " + (timeTaken / 1_000_000_000.0) + " seconds");
    }
}
//To solve in linear time 
//Use Formula
// (n-1+m-1)!/ ((n-1)!(m-1)!)