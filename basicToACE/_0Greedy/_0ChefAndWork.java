package basicToACE._0Greedy;

import java.util.Scanner;

//  https://www.codechef.com/problems/CHEFNWRK
//  https://youtu.be/qdFUpU7sdRs?t=3447
public class _0ChefAndWork {

  /*
  * fails
  * 1
    1 1
    1
* */
  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    long t, n, k;
    t = sc.nextLong();
    while (t-- > 0) {
      n = sc.nextLong();
      k = sc.nextLong();

      long[] wts = new long[(int) n];
      for (long i = 0; i < n; i++) {
        wts[(int) i] = sc.nextLong();
      }

      int noOfTrips = 1;
      long maxWtCanCarry = 0;
      for (long i = 0; i < n; i++) {
        if (wts[(int) i] > k) {
          noOfTrips = -1;
          break;
        }
        maxWtCanCarry += wts[(int) i];
        if (maxWtCanCarry > k) {
          maxWtCanCarry = wts[(int) i];
          noOfTrips++;
        }
      }
      System.out.println(noOfTrips);
    }
  }
}
