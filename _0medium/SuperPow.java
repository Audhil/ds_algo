package _0medium;

//  https://leetcode.com/problems/super-pow/
/*
* Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.



Example 1:

Input: a = 2, b = [3]
Output: 8
Example 2:

Input: a = 2, b = [1,0]
Output: 1024
Example 3:

Input: a = 1, b = [4,3,3,8,5,2]
Output: 1
Example 4:

Input: a = 2147483647, b = [2,0,0]
Output: 1198


Constraints:

1 <= a <= 2^31 - 1
1 <= b.length <= 2000
0 <= b[i] <= 9
b doesn't contain leading zeros.
*
* https://baihuqian.github.io/2018-08-20-super-pow/
* */
public class SuperPow {

    private static final int MOD = 1337;

    public static int superPow(int a, int[] b) {
        a = a % MOD;
        if (a == 0)
            return a;
        if (b.length == 0)
            return 1;

        int res = powMod(a, b[0]);
        for (int i = 1; i < b.length; i++)
            res = (powMod(res, 10) * powMod(a, b[i])) % MOD;
        return res;
    }

    private static int powMod(int a, int b) {
        if (b == 0)
            return 1;
        a = a % MOD;
        int res = a;
        for (int i = 1; i < b; i++)
            res = res * a % MOD;
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: pow : " + superPow(2, new int[]{1, 0}));
    }
}
