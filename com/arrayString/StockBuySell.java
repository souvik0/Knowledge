package com.arrayString;

public class StockBuySell {

    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static int maxProfit(int[] prices) {
         int n = prices.length;
         if (n <= 1) {
             return 0;
         }

         int maxProfit = 0;
         int minPrice = prices[0];

         for (int i = 1; i < n; i++) {
             int currentPrice = prices[i];
             int profit = currentPrice - minPrice;
             maxProfit = Math.max(maxProfit, profit);
             minPrice = Math.min(minPrice, currentPrice);
         }

         return maxProfit;
    }
}
