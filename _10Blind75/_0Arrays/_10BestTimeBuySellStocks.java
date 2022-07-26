package _10Blind75._0Arrays;

//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _10BestTimeBuySellStocks {

  //  a. 1 time buy & 1 time sell - EASY
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 1) {
      return 0;
    }
    int minBuy = prices[0], maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > minBuy) {
        maxProfit = Math.max(maxProfit, prices[i] - minBuy);
      } else {
        minBuy = prices[i];
      }
    }
    return maxProfit;
  }

  //  b. no limit in buy/sell - EASY
  public static int maxProfitNoLimitTransaction(int[] prices) {
    if (prices == null || prices.length == 1) {
      return 0;
    }
    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        maxProfit += prices[i + 1] - prices[i];
      }
    }
    return maxProfit;
  }

  //  c. max profit at most with 2 transaction (0 transactions or 1 transaction or 2 transaction) - HARD
  //  https://www.youtube.com/watch?v=lJMJHY9Clx0&ab_channel=KashishMehndiratta
  //  check src code @ https://github.com/Audhil/ds_algo/blob/main/_13BuySellStocksMaxProfit/_3BuySellStocks3.java
  public static int maxProfitAtMost2Transactions(int[] prices) {
    if (prices == null || prices.length == 1) {
      return 0;
    }
    //  states
    //  s0 = 1B; s1 = 1B 1S; s2 = 2B 1S; s3 = 2B 2S;
    int s0 = Integer.MIN_VALUE, s1 = 0, s2 = Integer.MIN_VALUE, s3 = 0;
    for (int price : prices) {
      s3 = Math.max(s3, s2 + price);  //  2B 2S
      s2 = Math.max(s2, s1 - price);  //  2B 1s
      s1 = Math.max(s1, s0 + price);  //  1B 1S
      s0 = Math.max(s0, -price);  //  1B
    }
    return Math.max(s1, s3);  //  profit can be done 1B 1S or 2B 2S not otherwise
  }


  public static void main(String[] args) {
    System.out.println(
        "yup: maxProfit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));  //  yup: maxProfit: 5
    System.out.println(
        "yup: again maxProfit: " + maxProfit(new int[]{7, 6, 4, 3, 1})); //  yup: again maxProfit: 0
    System.out.println("yup: maxProfitNoLimitTransaction: " + maxProfitNoLimitTransaction(
        new int[]{2, 4, 1, 3, 3, 2, 6, 4, 2, 3}));  //  yup: maxProfitNoLimitTransaction: 9
    System.out.println(
        "yup: maxProfit: at most 2 transactions done: " + maxProfitAtMost2Transactions(
            new int[]{2, 4, 3, 6, 9, 4}));
  }
}
