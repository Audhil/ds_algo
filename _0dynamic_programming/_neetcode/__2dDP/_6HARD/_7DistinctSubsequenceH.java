package _0dynamic_programming._neetcode.__2dDP._6HARD;

import java.util.Arrays;

//  based on: _1LongestCommonSubsequenceM.java
//  https://youtu.be/qMky6D6YtXU?t=6958
public class _7DistinctSubsequenceH {

  //  TC: O(m * n); SC: O (m * n)
  public static int numDistinct(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    return dfs(0, 0, s, t, dp);
  }

  private static int dfs(int i, int j, String s, String t, int[][] dp) {
    //  base condition - https://youtu.be/qMky6D6YtXU?t=7452
    if (j >= t.length()) {
      return 1;
    }
    if (i >= s.length()) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (s.charAt(i) == t.charAt(j)) {
      return dp[i][j] = dfs(i + 1, j + 1, s, t, dp) + dfs(i + 1, j, s, t, dp);
    }
    return dp[i][j] = dfs(i + 1, j, s, t, dp);
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: num of distinct subsequence: " + numDistinct("rabbbit", "rabbit"));  //  3
    System.out.println("yup: num of distinct subsequence: " + numDistinct("babgbag", "bag")); //  5
  }
}
