package _10Blind25;

//  https://www.youtube.com/watch?v=Lj68VJ1wu84&ab_channel=Pepcoding
public class _2UglyNumbersM {

  private static int soln(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;  //  1 is the first ugly number any way
    int p2 = 1; //  ptr of 2
    int p3 = 1; //  ptr of 3
    int p5 = 1; //  ptr of 5

    for (int i = 1; i < n; i++) {
      int f1 = 2 * dp[p2];
      int f3 = 3 * dp[p3];
      int f5 = 5 * dp[p5];
      int min = Math.min(f1, Math.min(f3, f5));
      dp[i] = min;
      if (f1 == min) {
        p2++;
      } else if (f3 == min) {
        p3++;
      } else {
        p5++;
      }
    }
    return dp[n];
  }
}
