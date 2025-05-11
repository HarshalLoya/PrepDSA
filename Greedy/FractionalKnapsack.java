
import java.util.Arrays;

class Item {

    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {

    // TC: O(NlogN) + O(N), (sorting + iterating, SC: O(1)
    static double getProfit(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));

        int weight = 0;
        double profit = 0;

        for (Item item : items) {
            if (item.weight + weight > capacity) {
                int rem = capacity - weight;
                profit += (double) (item.value * rem / item.weight);
                break;
            } else {
                weight += item.weight;
                profit += item.value;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int capacity = 50;
        Item items[] = {new Item(100, 20), new Item(60, 10), new Item(120, 30)};
        System.out.println(getProfit(items, capacity));
    }
}
