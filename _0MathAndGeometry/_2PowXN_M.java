package _0MathAndGeometry;

//  https://leetcode.com/problems/powx-n
//  https://youtu.be/g9YQyYi4IQQ - neetcode
public class _2PowXN_M {

  public static double myPow(double x, int n) {
    double res = helper(x, Math.abs(n));
    if (n >= 0) {
      return res;
    }
    return 1 / res;
  }

  private static double helper(double x, int n) {
    if (x == 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    double res = helper(x * x, n / 2);
//    if n is even
    if (n % 2 == 0) {
      return res;
    }
//    if n is odd
    return x * res;
  }

  public static void main(String[] args) {
    System.out.println("yup: myPow(): " + myPow(2.00000, 10));  //  yup: myPow(): 1024.0
    System.out.println("yup: myPow(): " + myPow(2.10000, 3)); //  yup: myPow(): 9.261000000000001
    System.out.println("yup: myPow(): " + myPow(2.00000, -2));  //  yup: myPow(): 0.25
  }
}
