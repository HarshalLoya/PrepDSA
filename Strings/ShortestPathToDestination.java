
public class ShortestPathToDestination {

    public static double shortestDist(String s) {
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N' -> x += 1;
                case 'S' -> x -= 1;
                case 'E' -> y += 1;
                case 'W' -> y -= 1;
                default -> {
                }
            }
        }
        return Math.sqrt(x * x + y * y);
    }

    public static void main(String[] args) {
        String s = "WNEENESWENNN";
        System.out.printf("%.2f", shortestDist(s));
    }
}
