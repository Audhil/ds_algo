package _0easy;

//  https://www.youtube.com/watch?v=l0YC3876qxg
/*
* https://leetcode.com/problems/powx-n/
*
* Implement pow(x, n), which calculates x raised to the power n (i.e., xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25


Constraints:

-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
-10^4 <= x^n <= 10^4

*
*/
public class PowXN {
    /*
     * tip:
     * 1. [n % 2 == 0] -> x * x & n = n/2
     * 2. [n % 2 == 1] -> x * x & n = n - 1
     * refer video
     * */

    public static double myPow(double x, int n) {
        double ans = 1.0;
        long powN = n;

        if (powN < 0)
            powN *= -1; //  make it possible, for ease operations

        while (powN > 0) {
            //  if powN is even
            if (powN % 2 == 0) {
                x *= x;
                powN /= 2;
            }
            //  if powN is odd
            else {
                ans *= x;
                powN -= 1;
            }
        }
        //  if it is given as negative power
        if (n < 0)
            ans = 1.0 / ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("yup: mPow(x, n): " + myPow(2.0, -3));
        System.out.println("yup: mPow(x, n): " + myPow(2.0, 3));

    }
}
