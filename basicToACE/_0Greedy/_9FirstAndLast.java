package basicToACE._0Greedy;

import java.util.Scanner;

//  https://www.codechef.com/submit/FIRSTANDLAST
public class _9FirstAndLast {

  private static void rotateArray(long[] arr, long k) {
    if (arr == null) {
      return;
    }
    long n = arr.length;
    reverse(0, n - k - 1, arr);
    reverse(n - k, n - 1, arr);
    reverse(0, n - 1, arr);
  }

  private static void reverse(long s, long e, long[] arr) {
    long temp;
    while (s < e) {
      temp = arr[(int) s];
      arr[(int) s] = arr[(int) e];
      arr[(int) e] = temp;
      s++;
      e--;
    }
  }

//  public static void main(String[] args) throws java.lang.Exception {
//    Scanner sc = new Scanner(System.in);
//    int t;
//    t = sc.nextInt();
//    while (t-- > 0) {
//      long n = sc.nextLong();
//      long[] arr = new long[(int) n];
//      for (int i = 0; i < n; i++) {
//        arr[i] = sc.nextLong();
//      }
//      System.out.println("yup: " + Arrays.toString(arr));
//      long rotationCount = 0;
//      long maxSum = arr[0] + arr[(int) (n - 1)];
//      while (rotationCount < n) {
//        rotateArray(arr, 1);
//        maxSum = Math.max(maxSum, arr[0] + arr[(int) (n - 1)]);
//        rotationCount++;
//      }
//      System.out.println(maxSum);
//    }
//  }

  //  solution without rotation of array - simple
  /*
    based on: https://www.youtube.com/watch?v=Yei31B-pUuM&ab_channel=CodeChef
   * [a,b,c,d,e] -> a + e
   * [e,a,b,c,d] -> e + d
   * [d,e,a,b,c] -> d + c
   * [c,d,e,a,b] -> c + b
   * [b,c,d,e,a] -> b + a
   *
   * hence rotating or not rotating doesn't matter, solution can be found by max(b+a, c+b, d+c, e+d, a+e);
   * */
  /*
  * output:
  * 1
    3
    2
    3
    1
    yup: [2, 3, 1]
    5
  */
  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    while (t-- > 0) {
      long n = sc.nextLong();
      long[] arr = new long[(int) n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      long maxSum = arr[0] + arr[(int) (n - 1)];
      for (int i = 0; i < arr.length - 1; i++) {
        maxSum = Math.max(maxSum, arr[i] + arr[i + 1]);
      }
      System.out.println(maxSum);
    }
  }
}
