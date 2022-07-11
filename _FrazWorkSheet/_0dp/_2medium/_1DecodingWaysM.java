package _FrazWorkSheet._0dp._2medium;

//  https://leetcode.com/problems/decode-ways/
public class _1DecodingWaysM {

  //  explanation: https://www.youtube.com/watch?v=np1tSnaYG10&ab_channel=codeExplainer
  public static int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;  //  don't bother
    dp[1] = s.charAt(0) == '0' ? 0 : 1; //  base case
    for (int i = 2; i <= n; i++) {
      int d = s.charAt(i - 1) - '0';  //  considering single digit
      int dd =
          (10 * (s.charAt(i - 2) - '0')) + (s.charAt(i - 1) - '0'); //  considering double digits
      if (d >= 1) {
        dp[i] += dp[i - 1];
      }
      if (dd >= 10 && dd <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println("yup: decoding ways: " + numDecodings("12"));  //  yup: decoding ways: 2
    System.out.println("yup: decoding ways: " + numDecodings("226"));  //  yup: decoding ways: 3
    System.out.println("yup: decoding ways: " + numDecodings("06"));  //  yup: decoding ways: 0
    System.out.println("yup: decoding ways: " + numDecodings("12"));  //  yup: decoding ways: 2
  }
}
