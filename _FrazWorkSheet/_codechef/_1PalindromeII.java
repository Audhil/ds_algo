package _FrazWorkSheet._codechef;

import java.util.Scanner;

//  https://www.codechef.com/problems/MAKEPAL2
public class _1PalindromeII {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t, n;
    t = sc.nextInt();
    n = sc.nextInt();
    while (t-- > 0) {
      String s = sc.nextLine();
      int countOf0 = 0, countOf1 = 0;
      for (char ch : s.toCharArray()) {
        if (ch == '0') {
          countOf0++;
        } else {
          countOf1++;
        }
      }
      if (countOf0 <= countOf1) {
        while (countOf1-- > 0) {
          System.out.print('1');
        }
      } else {
        while (countOf0-- > 0) {
          System.out.print('0');
        }
      }
    }
  }
}
