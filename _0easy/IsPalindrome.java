package _0easy;

//  https://leetcode.com/problems/palindrome-number/
/*
*
* Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.



Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false
*
*

Constraints:
-2^31 <= x <= 2^31 - 1


* Follow up: Could you solve it without converting the integer to a string?

* */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int origX = x;
        int reversed = 0;
        int lastDigit;
        while (x != 0) {
            lastDigit = x % 10;
            x /= 10;
            reversed = (reversed * 10) + lastDigit;
        }
        return reversed == origX;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + isPalindrome(-12321));
    }
}
