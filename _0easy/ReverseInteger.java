package _0easy;

//  https://leetcode.com/problems/reverse-integer/
/*
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int reversed = 0;
        int lastDigit;
        while (x != 0) {
            lastDigit = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 || reversed == Integer.MAX_VALUE / 10 && lastDigit > 7)     //  2^31 - 1 = 2,14,74,83,647
                return 0;

            if (reversed < Integer.MIN_VALUE / 10 || reversed == Integer.MIN_VALUE / 10 && lastDigit < -8)    //  -2^31 = -2,14,74,83,648
                return 0;

            reversed = (reversed * 10) + lastDigit;
        }
        return reversed;
    }

    public static void main(String[] args) {
//        System.out.println("yup: " + reverse(-2147483648));
        System.out.println("yup: " + reverse(2147483647));
    }
}
