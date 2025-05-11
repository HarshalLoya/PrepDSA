
import java.util.ArrayList;
import java.util.List;

public class GreedyCoinChange {

    // TC: O(V), SC: O(V)
    public static List<Integer> coinChange(int[] denominations, int value) {
        List<Integer> ans = new ArrayList<>();
        for (int i = denominations.length - 1; i >= 0; i--) {
            if (value >= denominations[i]) {
                while (value >= denominations[i]) {
                    value -= denominations[i];
                    ans.add(denominations[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int denominations[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int value = 49;
        List<Integer> coins = coinChange(denominations, value);
        System.out.println("Coins: " + coins);
        System.out.println("Max number of coins: " + coins.size());
    }
}
