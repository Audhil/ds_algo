package _0dynamic_programming._neetcode.__2dDP;

import java.util.HashMap;
import java.util.Map;

//  https://youtu.be/qMky6D6YtXU?t=2704
public class _3CoinChangeII_NoOfWaysToChoose_M {

  //  BOTTOM-UP approach
  //  TC: O (noOfCoins * amount) & SC: O (noOfCoins * amount)
  public static int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    for (int a = 0; a <= amount; a++) {
      for (int c = coins.length - 1; c >= 0; c--) {
        //  https://youtu.be/qMky6D6YtXU?t=3534 - how array gets filled
        if (a == 0) {
          dp[c][a] = 1; //  base case, it's only 1 way to make amount 0, with given coin - ie., not choosing any coin
        } else {
          //  not choosing the coin - goto next coin
          dp[c][a] = dp[c + 1][a];  //  going down
          //  choosing the coin - stay in same coin and check the value in the same row
          if (a - coins[c] >= 0) {  //  to prevent index out of bound
            dp[c][a] += dp[c][a - coins[c]];  //  going right
          }
        }
      }
    }
    return dp[0][amount];
  }

  //  BOTTOM-UP approach
  //  optimized space complexity solution -
  //  dp solution - TC: O (n * amount), SC: (n)  - https://youtu.be/qMky6D6YtXU?t=3178
  public static int changeOptimizedSC(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    //  if amount is 0, no of ways to make it 0 is 1
    dp[0] = 1;
    for (int coin : coins) {
      for (int a = 1; a <= amount; a++) {
        if (coin <= a) {
          dp[a] += dp[a - coin];
        }
      }
    }
    return dp[amount];
  }


  //  TOP-DOWN - MEMOIZATION
  //  TC: O (c^n) -> we can reduce it to O (n*amount) & SC: O (c * n)
  public static int changeTopDownApproach(int amount, int[] coins) {
    Map<String, Integer> dpMap = new HashMap<>();
    return dfs(0, 0, dpMap, amount, coins);
  }

  private static int dfs(int index,
      int chosenAmtSoFar,
      Map<String, Integer> dpMap,
      int givenAmt,
      int[] coins) {
    //  completed the iteration
    if (chosenAmtSoFar == givenAmt) {
      return 1;
    }
    //  out of bound check
    if (chosenAmtSoFar > givenAmt) {
      return 0;
    }
    //  when there's no coins left to iterate
    if (index >= coins.length) {
      return 0;
    }
    String key = index + "_" + chosenAmtSoFar;
    if (dpMap.containsKey(key)) {
      return dpMap.get(key);
    }
    //  not choosing the coin -  iterate to next coin
    int notChoosingCoin =
        dfs(index + 1, chosenAmtSoFar, dpMap, givenAmt, coins);
    //  choosing the coin - add coinAmt in chosenAmtSoFar
    int choosingTheCoin =
        dfs(index, coins[index] + chosenAmtSoFar, dpMap, givenAmt, coins);
    dpMap.put(key, notChoosingCoin + choosingTheCoin);
    return dpMap.get(key);
  }

  public static void main(String[] args) {
    int amt = 5;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + change(amt,
            new int[]{1, 2, 5})); //  yup: no of ways to make amount : 5, is : 4

    amt = 3;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + change(amt,
            new int[]{2})); //  yup: no of ways to make amount : 3, is : 0

    amt = 10;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + change(amt,
            new int[]{10})); //  yup: no of ways to make amount : 10, is : 1

    System.out.println("yup: TOP-DOWN approach: ");

    amt = 5;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + changeTopDownApproach(amt,
            new int[]{1, 2, 5})); //  yup: no of ways to make amount : 5, is : 4

    amt = 3;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + changeTopDownApproach(amt,
            new int[]{2})); //  yup: no of ways to make amount : 3, is : 0

    amt = 10;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + changeTopDownApproach(amt,
            new int[]{10})); //  yup: no of ways to make amount : 10, is : 1

    System.out.println("yup: space optimized solution: ");

    amt = 5;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + changeOptimizedSC(amt,
            new int[]{1, 2, 5})); //  yup: no of ways to make amount : 5, is : 4

    amt = 3;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + changeOptimizedSC(amt,
            new int[]{2})); //  yup: no of ways to make amount : 3, is : 0

    amt = 10;
    System.out.println(
        "yup: no of ways to make amount : " + amt + ", is : " + changeOptimizedSC(amt,
            new int[]{10})); //  yup: no of ways to make amount : 10, is : 1
  }
}
