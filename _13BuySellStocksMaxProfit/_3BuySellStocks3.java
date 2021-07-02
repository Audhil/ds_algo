package _13BuySellStocksMaxProfit;

//  https://www.youtube.com/watch?v=lJMJHY9Clx0
//  max profit at most with 2 transaction (0 transactions or 1 transaction or 2 transaction)
//  TC: O(n); SC: O(1)
//  notes @ https://photos.google.com/photo/AF1QipNd01vfYcCMr2NwvGKoAMqeYALyeui0axdmhurX
public class _3BuySellStocks3 {
    /*
    states
    * s0 -> 1b
    * s1 -> 1b 1s
    * s2 -> 2b 1s
    * s3 -> 2b 2s
        buy     = -ve
        sell    = +ve
    * */
    private static int maxProfit(int[] prices) {
        if (prices == null)
            return 0;
        if (prices.length == 1)
            return prices[0];

        int s0 = Integer.MIN_VALUE, s1 = 0, s2 = Integer.MIN_VALUE, s3 = 0;
        for (int i = 0; i < prices.length; i++) {
            s3 = Math.max(s3, s2 + prices[i]);  //  2b 2s
            s2 = Math.max(s2, s1 - prices[i]);  //  2b 1s
            s1 = Math.max(s1, s0 + prices[i]);  //  1b 1s
            s0 = Math.max(s0, -prices[i]);  //  1b
        }
        return Math.max(0, Math.max(s1, s3));// 0 - NO TRANSACTION DONE, S1 - 1 transaction done(1b 1s), S3 - 2 transactions done(2b 2s)
    }

    public static void main(String[] args) {
        int[] prices = {2, 4, 3, 6, 9, 4};  //  stock prices
        System.out.println("yup: maxProfit: at most 2 transactions done: " + maxProfit(prices));
    }
}