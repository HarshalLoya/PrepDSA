
import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        int ans = 0;

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                ans++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] greedFactor = {1, 5, 3, 3, 4};
        int[] size = {4, 2, 1, 2, 1, 3};
        System.out.println(findContentChildren(greedFactor, size));
    }
}
