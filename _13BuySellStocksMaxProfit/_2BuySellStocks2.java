package _13BuySellStocksMaxProfit;

//  https://www.youtube.com/watch?v=1ZjFvzt3Knw
//  no restrictions in Buy/Sell count
//  TC: O(n); SC: O(1)
public class _2BuySellStocks2 {

    private static int maxProfit(int[] prices) {
        if (prices == null)
            return 0;
        if (prices.length == 1)
            return prices[0];

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("yup: maxProfit: " + maxProfit(new int[]{2, 4, 1, 3, 3, 2, 6, 4, 2, 3}));
    }
}
