package _0easy;

//  https://leetcode.com/problems/maximum-69-number/
/*
* Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).



Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.


Constraints:

1 <= num <= 10^4
num's digits are 6 or 9.
* */
public class Max69Num {

    //  replacing first occurence of '6' with '9' will yield the max number
    public static int maximum69Number(int num) {
        String nStr = String.valueOf(num);
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < nStr.length(); i++) {
            if (nStr.charAt(i) == '6') {
                sBuilder.append(nStr, 0, i);
                sBuilder.append('9');
                sBuilder.append(nStr, i + 1, nStr.length());
                return Integer.parseInt(sBuilder.toString());
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("yup: max: " + maximum69Number(9669));
        System.out.println("yup: max: " + maximum69Number(9996));
        System.out.println("yup: max: " + maximum69Number(9999));
    }
}
