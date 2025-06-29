package _00Arrays;

import java.util.Scanner;

//  https://www.youtube.com/watch?v=AQssUsQu_WE&ab_channel=CodeChef
//  https://www.codechef.com/problems/REVSORT
public class _0ReverseSortE_Chef {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t, n, x;
    t = sc.nextInt();
    while (t-- > 0) {
      n = sc.nextInt();
      x = sc.nextInt();
      int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = sc.nextInt();
      }

      int mx = 0;
      boolean canBeSorted = true;
      for (int i = 0; i < n; i++) {
        if (mx > array[i] && mx + array[i] > x) {
          canBeSorted = false;
        }
        mx = Math.max(mx, array[i]);
      }
      if (canBeSorted) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
