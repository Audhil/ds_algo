package _6SlidingWindowAlgo._neetcode;

//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _0BestTimeToBuySellStocks {

  //  TC: O (n); SC: O (1)
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 1) {
      return 0;
    }
    int minBuy = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > minBuy) {
        maxProfit = Math.max(maxProfit, prices[i] - minBuy);
      } else {
        minBuy = prices[i];
      }
    }
    return maxProfit;
  }

  //  TC: O (n); SC: O (1)
  //  2 ptr technique - https://youtu.be/1pkOgXD63yU
  public static int maxProfitWith2ptr(int[] prices) {
    if (prices == null || prices.length == 1) {
      return 0;
    }
    int l = 0, r = 1; //  indices
    int n = prices.length;
    int maxProfit = 0;
    while (l < n && r < n) {
      if (prices[l] > prices[r]) {
        l++;
      } else {
        maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
      }
      r++;
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println("yup: maxProfit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));  //  5
    System.out.println("yup: maxProfit: " + maxProfit(new int[]{7, 6, 4, 3, 1})); //  0

    System.out.println("yup: maxProfitWith2ptr: " + maxProfitWith2ptr(new int[]{7, 1, 5, 3, 6, 4}));  //  5
    System.out.println("yup: maxProfitWith2ptr: " + maxProfitWith2ptr(new int[]{7, 6, 4, 3, 1})); //  0
  }
}
