package _0MathAndGeometry;

//  https://youtu.be/ljz85bxOYJ0
//  https://leetcode.com/problems/happy-number/description/

import java.util.HashSet;
import java.util.Set;

//  hint: refer detect cycle in linked list for memory efficient solution
public class _0HappyNumberE {

  //  hint: detecting cycle, if it is 1 then it is happy number else unhappy number
  //  TC: O (N)
  public static boolean isHappy(int n) {
    if (n == 1) {
      return true;
    }
    Set<Integer> visitedSet = new HashSet<>();
    while (!visitedSet.contains(n)) {
      visitedSet.add(n);
      n = sumOfSquares(n);
      if (n == 1) {
        return true;
      }
    }
    return false;
  }

  private static int sumOfSquares(int n) {
    int output = 0;
    while (n > 0) {
      int digit = n % 10;
      output += (digit * digit);
      n /= 10;
    }
    return output;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: is it a happy number: " + isHappy(19));  //  yup: is it a happy number: true
    System.out.println(
        "yup: is it a happy number: " + isHappy(2)); //  yup: is it a happy number: false
  }
}
