package _0easy;

//  https://leetcode.com/problems/sqrtx/
/*
* Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.



Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.


Constraints:

0 <= x <= 2^31 - 1
*
* https://www.youtube.com/watch?v=7womRtj_HHA - using binary search
*
* TC: O(log num)
* SC: O(1)
* */
public class SqrtOfX {

    public static int sqrtOf(int num) {
        if (num == 0 || num == 1)
            return num;

        //  sqrt of x will be between 0..x/2 +1;
        int left = 0, right = (num / 2) + 1, square, mid;
        while (left < right) {
            mid = left + ((right - left) / 2) + 1;  //  +1 just picks upper mid value -> [1, 2] it'll pick 2 instead of 1
            square = mid * mid;
            if (square == num)
                return mid;
            if (square < num)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

    //  explore this too
    public int mySqrt(int x) {
        double root, i;
        for (root = x, i = 0; i < 100; i++, root = ((root + (x / root)) / 2));
        return (int) root;
    }

    public static void main(String[] args) {
//        System.out.println("yup: sqrt: " + sqrtOf(8));
//        System.out.println("yup: sqrt: " + sqrtOf(16));
        System.out.println("yup: sqrt: " + sqrtOf(139));
    }
}
