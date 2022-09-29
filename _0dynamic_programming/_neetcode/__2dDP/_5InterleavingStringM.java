package _0dynamic_programming._neetcode.__2dDP;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/interleaving-string/
//  https://youtu.be/qMky6D6YtXU?t=5061
public class _5InterleavingStringM {

  //  TC: O (len of s1 * len of s2); SC: O (m * n)
  public static boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    Map<String, Boolean> dpMap = new HashMap<>();
    return dfs(0, 0, dpMap, s1, s2, s3);
  }

  private static boolean dfs(
      int i,
      int j,
      Map<String, Boolean> dpMap,
      String s1,
      String s2,
      String s3) {
    //  base case - when both strings are empty, we can make match it with empty string of result
    if (i >= s1.length() && j >= s2.length()) {
      return true;
    }
    String key = i + "," + j;
    if (dpMap.containsKey(key)) {
      return dpMap.get(key);
    }
    if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(i + 1, j, dpMap, s1, s2, s3)) {
      return true;
    }
    if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(i, j + 1, dpMap, s1, s2, s3)) {
      return true;
    }
    dpMap.put(key, false);
    return dpMap.get(key);
  }

  //  BOTTOM-UP Approach
  public static boolean isInterleaveBottomUp(String s1, String s2, String s3) {
    int m = s1.length(), n = s2.length();
    if ((m + n) != s3.length()) {
      return false;
    }
    boolean[][] dp = new boolean[m + 1][n + 1];
    //  base case - when both strings are empty, we can make match it with empty string of result
    dp[m][n] = true;
    for (int i = m; i >= 0; i--) {
      for (int j = n; j >= 0; j--) {
        if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
          dp[i][j] = true;
        }
        if (j < n && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
          dp[i][j] = true;
        }
      }
    }

    return dp[0][0];
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: _5InterleavingStringM: " + isInterleave("aabcc", "dbbca", "aadbbcbcac")); //  true

    System.out.println(
        "yup: _5InterleavingStringM: " + isInterleave("aabcc", "dbbca", "aadbbbaccc")); //  false

    System.out.println(
        "yup: _5InterleavingStringM: " + isInterleave("", "", "")); //  true
    System.out.println("yup: bottom up solution: ");
    System.out.println(
        "yup: isInterleaveBottomUp: " + isInterleaveBottomUp("aabcc", "dbbca",
            "aadbbcbcac")); //  true

    System.out.println(
        "yup: isInterleaveBottomUp: " + isInterleaveBottomUp("aabcc", "dbbca",
            "aadbbbaccc")); //  false

    System.out.println(
        "yup: isInterleaveBottomUp: " + isInterleaveBottomUp("", "", "")); //  true
  }
}