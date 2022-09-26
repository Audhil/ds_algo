package _0dynamic_programming._neetcode.__2dDP;

//  https://leetcode.com/problems/longest-common-subsequence/
//  https://youtu.be/qMky6D6YtXU?t=707
public class _1LongestCommonSubsequenceM {

  //  BOTTOM-UP approach
  //  best expln: https://youtu.be/qMky6D6YtXU?t=1010

  //  TC: O (m * n); SC: O (m * n)
  public static int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    //  initialization: https://youtu.be/qMky6D6YtXU?t=1225
    int[][] dp = new int[m + 1][n + 1];
    for (int r = m - 1; r >= 0; r--) {
      for (int c = n - 1; c >= 0; c--) {
        //  is same char - 1(same char count) + diagonal grid value
        if (text1.charAt(r) == text2.charAt(c)) {
          dp[r][c] = 1 + dp[r + 1][c + 1];
        }
        //  else
        else {
          //  search LCS in right or down dir
          dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
        }
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {
    System.out.println("yup: LCS: " + longestCommonSubsequence("abcde", "ace"));  //  3
    System.out.println("yup: LCS: " + longestCommonSubsequence("abc", "abc"));  //  3
    System.out.println("yup: LCS: " + longestCommonSubsequence("abc", "def"));  //  0
  }
}
