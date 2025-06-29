package basicToACE._1dp;

import java.util.Arrays;

//  https://youtu.be/JHldgHi6DPM?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=6207
public class _3AliceBobPlayingWithDp {

  //  TC: O (n^2), SC: O (n)
  //  refer _1Basic_Recursion_2.java
  //  alice starts playing first.
  //  final answer:  0 - alice loses, bob win, 1 - alice win, bob lose
  private static int playing(int n, int[] dp) {
    if (n == 1) {
      return 0;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    for (int x = 1; x < n; x++) { //  TC: O (n)
      if (n % x == 0) {
        if (playing(n - x, dp) == 0) {
          return dp[n] = 1;
        }
      }
    }
    return dp[n] = 0;
  }

  //  reducing TC of for loop
  //  TC: O (n*sqrt(n)) or O (n^ 3/2)
  private static int playing2(int n, int[] dp) {
    if (n == 1) {
      return 0;
    }
    if (dp[n] != -1) {
      return dp[n];
    }

//    refer: https://youtu.be/JHldgHi6DPM?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=7107
//    for (int x = 1;
//        x <= Math.sqrt(n);
//        x++) { //  reducing the TC: O (sqrt(n))

//    or
    for (int x = 1;
        x * x < n;
        x++) { //  reducing the TC: O (sqrt(n))
      if (n % x == 0) {
        int secondFactor = n / x;
        if (playing2(n - x, dp) == 0) {
          return dp[n] = 1;
        }
        if (x != 1 && playing2(n - secondFactor, dp) == 0) {
          return dp[n] = 1;
        }
      }
    }
    return dp[n] = 0;
  }

  public static void main(String[] args) {
    int n = 3;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println("yup: playing: who wins: " + playing(n, dp));  //  yup: playing: who wins: 0
  }
}
