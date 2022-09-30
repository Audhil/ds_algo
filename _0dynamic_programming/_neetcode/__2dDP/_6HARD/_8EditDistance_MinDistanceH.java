package _0dynamic_programming._neetcode.__2dDP._6HARD;

import java.util.Arrays;

//  https://leetcode.com/problems/edit-distance/
//  https://youtu.be/qMky6D6YtXU?t=7644
public class _8EditDistance_MinDistanceH {

  //  BOTTOM-UP approach
  //  TC: O (m * n); SC: O (m * n)
  public static int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    //  base case
    for (int i = n; i >= 0; i--) {
      dp[m][i] = n - i;
    }
    for (int j = m; j >= 0; j--) {
      dp[j][n] = m - j;
    }
    //  bottom up fill
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (word1.charAt(i) == word2.charAt(j)) {
          dp[i][j] = dp[i + 1][j + 1];
        } else {
          dp[i][j] = 1 + (Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]));
        }
      }
    }
    return dp[0][0];
  }

  //  memoization - bottom up
  //  TC: O (m * n); SC: O (m * n)
  public static int minDistanceMemoization(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    return dfs(0, 0, word1, word2, dp);
  }

  private static int dfs(int i, int j, String word1, String word2, int[][] dp) {
    if (i >= word1.length() && j >= word2.length()) {
      return 0;
    }
    //  1 str is empty another is non-empty
    if (i == word1.length()) {
      return word2.length() - j;
    }
    if (j == word2.length()) {
      return word1.length() - i;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    //  go diagonal
    if (word1.charAt(i) == word2.charAt(j)) {
      return dp[i][j] = dfs(i + 1, j + 1, word1, word2, dp);
    }
    return dp[i][j] = 1 + Math.min(
        //  https://youtu.be/qMky6D6YtXU?t=7907
        Math.min(
            //  inserted a char in word1
            dfs(i, j + 1, word1, word2, dp),
            //  delete an item in word1
            dfs(i + 1, j, word1, word2, dp)),
        //  replace a char between word1 & word2
        dfs(i + 1, j + 1, word1, word2, dp)
    );
  }

  public static void main(String[] args) {
    System.out.println("yup: minDistance: " + minDistance("horse", "ros")); //  yup: minDistance: 3
    System.out.println(
        "yup: minDistance: " + minDistance("intention", "execution")); //  yup: minDistance: 5

    System.out.println("yup: memoization soln: ");
    System.out.println("yup: minDistanceMemoization: " + minDistanceMemoization("horse",
        "ros")); //  yup: minDistance: 3
    System.out.println(
        "yup: minDistanceMemoization: " + minDistanceMemoization("intention",
            "execution")); //  yup: minDistance: 5
  }
}
