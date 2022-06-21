package _10Blind25._3Binary;

//  https://leetcode.com/problems/sum-of-two-integers/
//  https://www.youtube.com/watch?v=gVUrDV4tZfY&ab_channel=NeetCode
public class _4Sum2IntegersWithoutMathOperatorsM {

  public static int getSum(int a, int b) {
    while (b != 0) {
      int temp = (a & b) << 1;  //  for tracing carry
      a = a ^ b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    System.out.println("yup: adding 2 numbers without + or - : " + getSum(1, 9));
    System.out.println("yup: adding 2 numbers without + or - : " + getSum(12, 7));
  }
}
