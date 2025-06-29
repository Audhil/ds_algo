package _10Blind75._0Arrays;

//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _0BestTimeToBuyStocksE {

  public static int maxProfit(int[] prices) {
    if (prices.length == 1) {
      return 0;
    }
    int maxProfit = 0;
    int minBuy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > minBuy) {
        maxProfit = Math.max(maxProfit, prices[i] - minBuy);
      } else {
        minBuy = prices[i];
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println("yup: maxProfit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));  //  5
    System.out.println("yup: 2nd maxProfit: " + maxProfit(new int[]{7, 6, 4, 3, 1})); //  0
  }
}
