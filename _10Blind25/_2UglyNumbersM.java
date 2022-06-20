package _10Blind25;

//  https://www.youtube.com/watch?v=Lj68VJ1wu84&ab_channel=Pepcoding
//  and this too
//  https://www.youtube.com/watch?v=QyeDRMprJVQ&ab_channel=CodingBlocks
public class _2UglyNumbersM {

  //  general form of ugly number
  //  x = 2^a * 3^b * 5^c
  //  ugly numbers as follows
  //  1, 2, 3, 4, 5, 6, 8, 9, 10, 12,
  private static int nthUglyNumber(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;  //  1 is the first ugly number any way
    int p2 = 1; //  ptr of 2
    int p3 = 1; //  ptr of 3
    int p5 = 1; //  ptr of 5

    for (int i = 2; i <= n; i++) {
      int f1 = 2 * dp[p2];
      int f3 = 3 * dp[p3];
      int f5 = 5 * dp[p5];
      int min = Math.min(f1, Math.min(f3, f5));
      if (dp[i - 1] != min) {
        dp[i] = min;
      }
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

  public static void main(String[] args) {
    System.out.println("yup: ugly number at pos: 10: " + nthUglyNumber(10));
  }
}
