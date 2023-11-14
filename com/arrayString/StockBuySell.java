package com.arrayString;

public class StockBuySell {

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            // If the current price is higher than the previous, we can sell
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
