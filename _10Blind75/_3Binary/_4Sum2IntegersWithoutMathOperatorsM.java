package _10Blind75._3Binary;

//  https://leetcode.com/problems/sum-of-two-integers/
//  https://www.youtube.com/watch?v=gVUrDV4tZfY&ab_channel=NeetCode
public class _4Sum2IntegersWithoutMathOperatorsM {

  //  TC: O (1), O (n) for bigger numbers

  //  for adding without +, -
  //  step1: (a & b) << 1 - for tracing carry
  //  step2: a ^ b
  //  step3: continue the loop until carry becomes 0
  public static int getSum(int a, int b) {
    while (b != 0) {
      int temp = (a & b) << 1;  //  for tracing carry
      a = a ^ b;
      b = temp;
    }
    return a;
  }

  public static int revision(int a, int b) {
    while (b != 0){
      int temp = (a & b) << 1;  //  carry
      a ^= b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) {
    System.out.println("yup: adding 2 numbers without + or - : " + getSum(1, 9)); //  10
    System.out.println("yup: adding 2 numbers without + or - : " + getSum(12, 7));  //  19
  }
}
