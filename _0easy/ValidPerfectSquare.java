package _0easy;

//  https://leetcode.com/problems/valid-perfect-square/
/*
*
* Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.



Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false


Constraints:

1 <= num <= 2^31 - 1
*
* */
public class ValidPerfectSquare {

  public static boolean revision(int num) {
    if (num == 0 || num == 1) {
      return true;
    }
    int l = 0, r = num, mid, square;
    while (l < r) {
      mid = (l + (r - l) / 2) + 1; //  +1 to select upper bound
      square = mid * mid;
      if (square == num) {
        return true;
      }
      if (square > num) {
        r = mid - 1;
      } else {
        l = mid;
      }
    }
    return false;
  }

  public static boolean isPerfectSquare(int num) {
    if (num == 0 || num == 1) {
      return true;
    }

    int left = 0, right = num, mid, square;
    while (left < right) {
      mid = left + ((right - left) / 2)
          + 1;    //  +1 just picks upper mid value -> [1, 2] it'll pick 2 instead of 1
      square = mid * mid;
      if (square == num) {
        return true;
      } else if (square < num) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("is it perfect square: " + isPerfectSquare(16)); //  true
    System.out.println("is it perfect square: " + isPerfectSquare(14)); //  false
    System.out.println("is it perfect square: " + revision(25)); //  true
    System.out.println("is it perfect square: " + isPerfectSquare(4));  //  true
    System.out.println("is it perfect square: " + isPerfectSquare(2));  //  false
    System.out.println("is it perfect square: " + revision(808201)); //  false
  }
}
