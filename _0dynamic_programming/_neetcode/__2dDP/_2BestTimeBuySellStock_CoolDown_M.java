package _0dynamic_programming._neetcode.__2dDP;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//  https://youtu.be/qMky6D6YtXU?t=1813
public class _2BestTimeBuySellStock_CoolDown_M {

  public static int maxProfit(int[] prices) {
    Map<String, Integer> dpMap = new HashMap<>();
    return dfs(dpMap, 0, prices, true);
  }

  //  returns max profit
  private static int dfs(Map<String, Integer> dpMap, int index, int[] prices, boolean isBuying) {
    if (index >= prices.length) {
      return 0;   //  we cannot return max profit, after we iterated whole prices
    }
    String key = index + "_" + isBuying;
    if (dpMap.containsKey(key)) {
      return dpMap.get(key);
    }
    //  I can buy or cooldown on the particular day
    if (isBuying) {
      int buy = dfs(dpMap, index + 1, prices, !isBuying) - prices[index];   //  I'm buying a stock
      int cooldown = dfs(dpMap, index + 1, prices, isBuying);   //  I'm doing cooldown on the day
      dpMap.put(key, Math.max(buy, cooldown));
    }
    //  I can sell or cooldown on the particular day
    else {
      int sell = dfs(dpMap, index + 2, prices, !isBuying)
          + prices[index];  //  I'm selling and next day will be cooldown hence, index+2
      int cooldown = dfs(dpMap, index + 1, prices, isBuying);
      dpMap.put(key, Math.max(sell, cooldown));
    }
    return dpMap.get(key);
  }

  public static void main(String[] args) {
    System.out.println("yup: max profit : " + maxProfit(new int[]{1, 2, 3, 0, 2})); //  3 -> [buy,sell,cooldown,buy,sell]
    System.out.println("yup: max profit : " + maxProfit(new int[]{1})); //  0 ->  [cooldown]
  }
}
