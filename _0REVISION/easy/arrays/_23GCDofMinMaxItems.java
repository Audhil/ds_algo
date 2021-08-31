package _0REVISION.easy.arrays;

//  https://leetcode.com/problems/find-greatest-common-divisor-of-array/
public class _23GCDofMinMaxItems {

    public static int findGCD(int[] nums) {
        if (nums == null)
            return 0;

        int minNo = Integer.MAX_VALUE;
        int maxNo = Integer.MIN_VALUE;
        for (Integer n : nums) {
            minNo = Math.min(minNo, n);
            maxNo = Math.max(maxNo, n);
        }
        int gcd = 1;
        for (int i = gcd; i <= minNo; i++) {
            if (minNo % i == 0 && maxNo % i == 0)
                gcd = i;
        }
        return gcd;
    }

    public static void main(String[] args) {
        System.out.println("yup: 2,5,6,9,10: GCD: " + findGCD(new int[]{2, 5, 6, 9, 10}));
        System.out.println("yup: 7,5,6,8,3: GCD: " + findGCD(new int[]{7, 5, 6, 8, 3}));
        System.out.println("yup: 3,3: GCD: " + findGCD(new int[]{3, 3}));
    }
}
