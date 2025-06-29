package _0dynamic_programming._neetcode.__2dDP;

import java.util.Arrays;

//  https://leetcode.com/problems/stone-game/
//  https://youtu.be/uhgdXOlGYqE?t=844 - alice is always going to win, check the video for good explanation
public class _3StoneGameM {

  //  TC: O (n^2); SC: O (n^2)
  public static boolean stoneGame(int[] piles) {
    int sumOfArray = Arrays.stream(piles).sum();
    int[][] dp = new int[piles.length][piles.length];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    return dfs(0, piles.length - 1, piles, dp) > sumOfArray / 2;
  }

  //  max alice total
  private static int dfs(int l, int r, int[] piles, int[][] dp) {
    if (l > r) {
      return 0;
    }
    if (dp[l][r] != -1) {
      return dp[l][r];
    }
    boolean isEvenArrLength = (r - l) % 2 == 0;
    int leftStoneContribution = 0, rightStoneContribution = 0;
    if (isEvenArrLength) {
      leftStoneContribution = piles[l];
    }
    if (isEvenArrLength) {
      rightStoneContribution = piles[r];
    }
    return dp[l][r] = Math.max(dfs(l + 1, r, piles, dp) + leftStoneContribution,
        dfs(l, r - 1, piles, dp) + rightStoneContribution);
  }

  public static void main(String[] args) {
    System.out.println("yup: stone game : " + stoneGame(new int[]{5, 3, 4, 5}));  //  true
    System.out.println("yup: stone game : " + stoneGame(new int[]{3, 7, 2, 3}));  //  true
  }
}
