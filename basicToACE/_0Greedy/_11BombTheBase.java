package basicToACE._0Greedy;

import java.util.Scanner;

//  https://www.codechef.com/submit/BOMBTHEBASE
public class _11BombTheBase {

  /*
   *
   *  2
      8 6
      4 1 6 1 6 5 6 8
      2 1
      3 5

      o/p -> 6, 0
      *
   */
  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      long n = sc.nextLong();
      long x = sc.nextLong();
      long[] homes = new long[(int) n];
      for (long i = 0; i < n; i++) {
        homes[(int) i] = sc.nextLong();
      }
      long count = 0;
      for (long i = n - 1; i >= 0; i--) {
        if (homes[(int) i] < x) {
          count = i + 1;
          break;
        }
      }
      System.out.println(count);
    }
  }
}
