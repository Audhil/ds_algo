package _0REVISION.easy.arrays;

import java.util.Arrays;

//  https://leetcode.com/problems/build-array-from-permutation/
public class _6BuildArrayFromPermutation {

    public static int[] buildArray(int[] nums) {
        if (nums == null)
            return nums;

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + Arrays.toString(buildArray(new int[]{1, 2, 1})));    //  yup: [2, 1, 2]
        System.out.println("yup: " + Arrays.toString(buildArray(new int[]{0, 2, 1, 5, 3, 4})));    //  yup: [0, 1, 2, 4, 5, 3]
    }
}
