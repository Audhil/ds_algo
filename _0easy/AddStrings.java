package _0easy;

//  https://leetcode.com/problems/add-strings/
/*
* Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.



Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"


Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
* */
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int sum, carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            sum = carry + x + y;
            stringBuilder.append(sum % 10); //  add last digit
            carry = sum / 10;   //  extract carry
        }
        if (carry > 0)
            stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("yup: " + addStrings("1789", "15"));
    }
}
