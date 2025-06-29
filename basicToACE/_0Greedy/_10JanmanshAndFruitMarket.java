package basicToACE._0Greedy;

import java.util.Scanner;

//  https://www.codechef.com/submit/JMARKET
public class _10JanmanshAndFruitMarket {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    long t;
    t = sc.nextLong();
    while (t-- > 0) {
      int x = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      int firstMin, secondMin;

      if (a < b && a < c) {
        firstMin = a;
        secondMin = Math.min(b, c);
      } else if (b < c) {
        firstMin = b;
        secondMin = Math.min(a, c);
      } else {
        firstMin = c;
        secondMin = Math.min(a, b);
      }
      // int minSpent = 0;
      // while(x > 0){
      //     minSpent += firstMin;
      //     x--;
      //     if(x == 1){
      //         minSpent += secondMin;
      //         x--;
      //     }
      // }
      // System.out.println(minSpent);
      //  or
      System.out.println((x - 1) * firstMin + secondMin);
    }
  }
}
