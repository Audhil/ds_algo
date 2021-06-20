package _0easy;

//  https://leetcode.com/problems/count-numbers-with-unique-digits/
/*
* Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.



Example 1:

Input: n = 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
Example 2:

Input: n = 0
Output: 1


Constraints:

0 <= n <= 8
* //    https://www.youtube.com/watch?v=dcnDIKBWWG0 - best explanation
* */
public class CountUniqueDigits {

//    wrong as per question
//    public static int countNumbersWithUniqueDigits(int n) {
//        if (n == 0)
//            return 1;
//        return (int) (Math.pow(10, n) - (9 * (n - 1))); //  wrong: considers only 11, 22, 33 ... 111, 222, 333 as duplicates, but 121, 133, 992 is also duplicates as per question
//    }

    /*
    d' = prev duplicates, nd' = prev non duplicates
    * d (duplicates) = d' * 10 + no Of digits' * nd'
      nd(non duplicates) = 10^digits - d
    * */

    //  https://www.youtube.com/watch?v=OkJKxoDbQ_c
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        if (n == 2)
            return 91;
        int k = 3;  //  looping from 3
        int prod = 81;
        int end = 8;
        
        while (k++ <= n) {

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + countNumbersWithUniqueDigits(0));
        System.out.println("yup: " + countNumbersWithUniqueDigits(1));
        System.out.println("yup: " + countNumbersWithUniqueDigits(2));
        System.out.println("yup: " + countNumbersWithUniqueDigits(3));
    }
}
