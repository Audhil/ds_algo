package basicToACE._0Greedy;

import java.util.Arrays;
import java.util.Scanner;

//  https://www.codechef.com/submit/HIGHSCORE
public class _7ScoreHigh {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    while (t-- > 0) {
      long n = sc.nextLong();
      long[] ansCountArray = new long[4];
      for (int i = 0; i < 4; i++) {
        ansCountArray[i] = sc.nextLong();
      }
//      System.out.println(Arrays.toString(ansCountArray));
      long maxMarks = Long.MIN_VALUE;
      for (int i = 0; i < 4; i++) {
        maxMarks = Math.max(maxMarks, ansCountArray[i]);
      }
      System.out.println(maxMarks);
    }
  }
}
