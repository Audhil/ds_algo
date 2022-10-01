package _0dynamic_programming._neetcode.__2dDP._6HARD;

//  https://leetcode.com/problems/regular-expression-matching/
//  https://youtu.be/qMky6D6YtXU?t=10143
public class _10RegularExpressionMatchingH {

  //  TC: O (m * n); SC: O (m * n) - https://youtu.be/qMky6D6YtXU?t=10575
  public static boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    return dfs(0, 0, s, p, dp);
  }

  private static boolean dfs(int i, int j, String s, String p, boolean[][] dp) {
    if (dp[i][j]) {
      return dp[i][j];
    }
    //  we've completed both strings and found matched
    if (i >= s.length() && j >= p.length()) {
      return true;
    }
    //  if pattern is exhausted we don't have anything to match with string s
    if (j >= p.length()) {
      return false;
    }
    //  helper variable
    boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.')));
    //  check for star - good explanation: https://youtu.be/qMky6D6YtXU?t=10765
    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      dp[i][j] =
          //  don't use the star
          dfs(i, j + 2, s, p, dp)
              //  use the star
              || (match && dfs(i + 1, j, s, p, dp));  //  https://youtu.be/qMky6D6YtXU?t=11508
    } else {
      dp[i][j] = (match && dfs(i + 1, j + 1, s, p, dp));  //  https://youtu.be/qMky6D6YtXU?t=11573
    }
    return dp[i][j];
  }

  public static void main(String[] args) {
    System.out.println("yup: regex matching: " + isMatch("", ""));
    System.out.println("yup: regex matching: " + isMatch("aa", "a"));
    System.out.println("yup: regex matching: " + isMatch("aa", "a*"));
    System.out.println("yup: regex matching: " + isMatch("ab", ".*"));
  }
}
