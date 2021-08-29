package _0REVISION.easy.arrays;

import java.util.Arrays;

//  https://leetcode.com/problems/concatenation-of-array/
public class _5ArrayConcatenation {

    public static int[] getConcatenation(int[] nums) {
        if (nums == null)
            return nums;
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + Arrays.toString(getConcatenation(new int[]{1, 2, 1})));    //  yup: [1, 2, 1, 1, 2, 1]
        System.out.println("yup: " + Arrays.toString(getConcatenation(new int[]{1, 3, 2, 1}))); //  yup: [1, 3, 2, 1, 1, 3, 2, 1]
    }
}
