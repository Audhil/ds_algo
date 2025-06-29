package basicToACE._0Greedy;

import java.util.Scanner;

//  https://youtu.be/qdFUpU7sdRs?t=6151
public class _2RacingHorses {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t, n;
    t = sc.nextInt();
    while (t-- > 0) {
      n = sc.nextInt();
      int[] skills = new int[n];
      for (int i = 0; i < n; i++) {
        skills[i] = sc.nextInt();
      }
      int minDiff = 1000000000;
      for (int i = 0; i < n - 1; i++) {
        minDiff = Math.min(minDiff, Math.abs(skills[i + 1] - skills[i]));
      }
      System.out.println(minDiff);
    }

  }
}
