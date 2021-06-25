package _13BuySellStocksMaxProfit;

//  https://www.youtube.com/watch?v=y7GCr5Bk2kY
//  TC: O(n); SC: O(1)
public class _1BestTimeBuySellStocks {

    private static int maxProfit(int[] prices) {
        if (prices == null)
            return 0;
        if (prices.length == 1)
            return prices[0];
        int minBuyPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minBuyPrice)
                maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
                //  if stock price is
            else {
//                minBuyPrice = Math.min(minBuyPrice, prices[i]);
                minBuyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("yup: maxProfit: " + maxProfit(new int[]{6, 2, 4, 3, 10, 7, 9}));
    }
}
