package basicToACE._0Greedy;

import java.util.Scanner;

//  https://www.codechef.com/submit/FLOW005
public class _8SmallestNumOfNotes {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    int[] denominations = {100, 50, 10, 5, 2, 1};
    while (t-- > 0) {
      long n = sc.nextLong();
      int noteCount = 0;
      for (int denomination : denominations) {
        while (n >= denomination) {
          n -= denomination;
          noteCount++;
        }
        if (n <= 0) {
          break;
        }
      }
      System.out.println(noteCount);
    }
  }
}
