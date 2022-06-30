package _10Blind25._6GreedyApproach._6TopQuestions;

import java.util.Scanner;

//  https://youtu.be/lZJGbS12mWo?list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&t=5713
//  https://www.codechef.com/problems/CASH
public class _2HardCash {

  /*
  * 2 - test cases
    5(n) 7(k)
    1 14 4 41 1 (Array)
    3(n) 9(k)
    1 10 19 (Array)
  * */

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    long t, n, k;
    t = sc.nextLong();
    while (t-- > 0) {
      n = sc.nextLong();
      k = sc.nextLong();
      long[] coins = new long[(int) (n + 1)];
      for (long i = 0; i < n; i++) {
        coins[(int) i] = sc.nextLong();
      }
      long sum = 0;
      for (long j = 0; j < n; j++) {
        sum += coins[(int) j];
      }
      System.out.println(sum % k);
    }
  }
}
