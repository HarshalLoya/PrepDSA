
public class BestTimeToBuyAndSellStock {

    // brute force TC: O(N^2)
    // public static int maxProfit(int[] prices) {
    //     int maxProfit = 0;
    //     for (int i = 0; i < prices.length; i++) {
    //         for (int j = i + 1; j < prices.length; j++) {
    //             int currProf = prices[j] - prices[i];
    //             if (currProf > maxProfit) {
    //                 maxProfit = currProf;
    //             }
    //         }
    //     }
    //     return maxProfit;
    // }

    // optimal 
    public static int maxProfit(int[] prices) {
        int minPrice = 0, maxProf = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else {
                maxProf = Math.max(maxProf, prices[i] - minPrice);
            }
        }
        return maxProf;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
