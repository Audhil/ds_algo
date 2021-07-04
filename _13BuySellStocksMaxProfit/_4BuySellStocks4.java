package _13BuySellStocksMaxProfit;

import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=KHrxlNR2ebc
public class _4BuySellStocks4 {

    private static void maxProfit(int k, List<Integer> prices) {
        if (prices == null || prices.size() == 0 || k == 0)
            return;

        int d = prices.size();

        //  for eg: k = 4 transactions, d = 6 days,
        //  we can't do 4 transactions in 6 days(only max 3 can be done -BSBSBS),
        //  then find maxProfit with max transactions done within 6 days
        //  this is O(n) time complexity solution
        if (k > d / 2) {
            int maxProfit = 0;
            for (int l = 0; l < d - 1; l++) {
                if (prices.get(l + 1) - prices.get(l) > 0) {
                    maxProfit += prices.get(l + 1) - prices.get(l);
                }
            }
            System.out.println("yup shortly maxProfit: " + maxProfit);
            return;
        }

        int[][] dp = new int[k + 1][d + 1];
        int temp;
        for (int i = 1; i <= k; i++) {  //  transactions
            for (int j = 1; j < d; j++) {   //  days
                temp = dp[i][j - 1];    //  no transaction on last day
                for (int t = 0; t < j; t++) {
                    temp = (t == 0) ?
                            Math.max(temp, prices.get(j) - prices.get(t))   //  only one transaction done on last day of the whole cycle
                            : Math.max(temp, dp[i - 1][t - 1] + prices.get(j) - prices.get(t)); //  transaction done on last day = dp[i - 1][t - 1] + prices.get(j) - prices.get(t)
                }
                dp[i][j] = temp;
            }
        }
        System.out.println("yup finally maxProfit: " + dp[k][d - 1]);
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0)
            return 0;

        int d = prices.length;

        //  for eg: k = 4 transactions, d = 6 days,
        //  we can't do 4 transactions in 6 days(only max 3 can be done -BSBSBS),
        //  then find maxProfit with max transactions done within 6 days
        //  this is O(n) time complexity solution
        if (k > d / 2) {
            int maxProfit = 0;
            for (int l = 0; l < d - 1; l++) {
                if (prices[l + 1] - prices[l] > 0) {
                    maxProfit += prices[l + 1] - prices[l];
                }
            }
            System.out.println("yup shortly maxProfit: " + maxProfit);
            return maxProfit;
        }

        int[][] dp = new int[k + 1][d + 1];
        int temp;
        for (int i = 1; i <= k; i++) {  //  transactions
            for (int j = 1; j < d; j++) {   //  days
                temp = dp[i][j - 1];    //  no transaction on last day
                for (int t = 0; t < j; t++) {
                    temp = (t == 0) ?
                            Math.max(temp, prices[j] - prices[t])   //  only one transaction done on last day of the whole cycle
                            : Math.max(temp, dp[i - 1][t - 1] + prices[j] - prices[t]); //  transaction done on last day = dp[i - 1][t - 1] + prices.get(j) - prices.get(t)
                }
                dp[i][j] = temp;
            }
        }
        return dp[k][d - 1];
    }

    public static void main(String[] args) {
//        maxProfit(2, Arrays.asList(2, 4, 1)); //  op:2
//        maxProfit(2, Arrays.asList(3, 2, 6, 5, 0, 3));

        System.out.println("yup: maxProfit: " + maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
