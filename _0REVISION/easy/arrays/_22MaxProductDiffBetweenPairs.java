package _0REVISION.easy.arrays;

//  https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
public class _22MaxProductDiffBetweenPairs {

    //  I avoided sorting since it'll not be better than O(n log n)
    //  TC: O(n), SC: O(1)
    public static int maxProductDifference(int[] nums) {
        if (nums == null)
            return 0;

        //  min1 <= min2 <= max1 <= max2
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n >= max2) {
                max1 = max2;
                max2 = n;
            } else if (n >= max1) {
                max1 = n;
            }
            if (n <= min2) {
                min1 = min2;
                min2 = n;
            } else if (n <= min1) {
                min1 = n;
            }
        }
        return (max1 * max2) - (min1 * min2);
    }

    public static void main(String[] args) {
        System.out.println("yup: 5,6,2,7,4: " + maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println("yup: 4,2,5,9,7,4,8: " + maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
    }
}
