package _0dynamic_programming._neetcode.__1dDP;

//  check java code from NeetCode tutorials
//  https://youtu.be/_i4Yxeh5ceQ?t=4921
public class _6DecodeWays_FINAL_WAY_M {

  //  brute force will have TC: O (2^n)
  //  refer: _1DecodingWays_DecodeWaysM.java for O (N) memory solution
  //  TC: O (n)
  private static int revision(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;  //  empty string
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i < s.length() + 1; i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }
      if (s.charAt(i - 2) == '1'
          || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }

  //  BOTTOM - UP approach
  private static int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1; // empty string
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i < s.length() + 1; i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }
      if (
          s.charAt(i - 2) == '1' ||
              (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')
      ) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }


  //  TOP - DOWN approach
  private static int numDecodingsTopDown(String s) {
    return numDecodingsTopDown(s, 0, new Integer[s.length()]);
  }

  private static int numDecodingsTopDown(String s, int i, Integer[] dp) {
    if (i == s.length()) {
      return 1;
    }
    if (s.charAt(i) == '0') {
      return 0;
    }
    if (dp[i] != null) {
      return dp[i];
    }
    int count = 0;
    count += numDecodingsTopDown(s, i + 1, dp);
    if (i < s.length() - 1
        && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
      count += numDecodingsTopDown(s, i + 2, dp);
    }
    return dp[i] = count;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: numOf ways to decode: " + numDecodings("12")); //  yup: numOf ways to decode: 2

    System.out.println(
        "yup: numOf ways to decode: " + numDecodings("121")); //  yup: numOf ways to decode: 3
    System.out.println(
        "yup: numOf ways to decode: " + numDecodings("09")); //  yup: numOf ways to decode: 0

    System.out.println(
        "yup: numOf ways to decode: " + numDecodings("32")); //  yup: numOf ways to decode: 1

    System.out.println(
        "yup: numOf ways to decode: " + numDecodingsTopDown("32")); //  yup: numOf ways to decode: 1
  }
}
