package basicToACE._1dp;

import java.util.Arrays;

//  https://youtu.be/JHldgHi6DPM?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=1768
public class _1fibSeriesWithDp {

  private static int fiboWithDp(int[] dp, int n) {
    if (n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }

    if (dp[n] != -1) {
      return dp[n];
    }
    return dp[n] = fiboWithDp(dp, n - 1) + fiboWithDp(dp, n - 2);
  }

  public static void main(String[] args) {
    int[] dp = new int[100];
    Arrays.fill(dp, -1);
    System.out.println(
        "yup: 5th item of fib series : " + fiboWithDp(dp, 15)); //  yup: 5th item of fib series : 3

  }
}
