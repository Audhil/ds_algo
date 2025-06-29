package _0dynamic_programming._neetcode.__1dDP;

import java.util.Arrays;

//  https://youtu.be/_i4Yxeh5ceQ?t=5846
//  https://leetcode.com/problems/coin-change/
public class _7CoinChange_MIN_COINS_NEEDED_FINAL_WAY_M {

  //  BOTTOM-UP
  //  TC: O (Amt * O (coins)); SC: O (Amt)
  public static int coinChange(int[] coins, int amt) {
    int[] dp = new int[amt + 1];
    Arrays.fill(dp, amt + 1);
    dp[0] = 0;  //  0 is the no of coins needed to make sum 0
    //  https://youtu.be/_i4Yxeh5ceQ?t=6735
    for (int a = 1; a <= amt; a++) {
      for (int coin : coins) {
        if (a - coin >= 0) {
          dp[a] = Math.min(
              dp[a],
              //  we may have computed dp[a] earlier with other coins before selecting the iterating coin
              1 + dp[a - coin]
              //  1 (current selected coin) + selected coin = 4, amount = 7, dp[7] = 1 +dp[7-4] => 1+dp[3]
          );
        }
      }
    }
    if (dp[amt] != amt + 1) {
      return dp[amt];
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: min coin needed to make the amount: " + coinChange(new int[]{1, 2, 5}, 11));
    System.out.println(
        "yup: min coin needed to make the amount: " + coinChange(new int[]{2}, 3));

    System.out.println(
        "yup: min coin needed to make the amount: " + coinChange(new int[]{1}, 0));
  }
}
