package leetcode;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        /*
            Time Complexity - O(n) where n is the length of prices
            Space Complexity - O(1)
         */
        if (prices.length <= 0) return 0;

        int profit = 0;
        int priceBought = -1;

        for (int i = 0; i < prices.length; i++) {
            if (priceBought < 0) {
                //looking to buy

                if (i == prices.length - 1) break;

                int todaysPrice = prices[i];
                int tomorrowsPrice = prices[i + 1];

                if (todaysPrice < tomorrowsPrice) {
                    priceBought = todaysPrice;
                }
            } else {
                //looking to sell
                if (i == prices.length - 1) {
                    profit += prices[i] - priceBought;
                    break;
                }

                int todaysPrice = prices[i];
                int tomorrowsPrice = prices[i + 1];
                if (todaysPrice > tomorrowsPrice) {
                    profit += prices[i] - priceBought;
                    priceBought = -1;
                }
            }
        }

        return profit;
    }
}
