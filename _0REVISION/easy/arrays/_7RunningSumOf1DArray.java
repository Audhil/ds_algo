package _0REVISION.easy.arrays;

import java.util.Arrays;

//  https://leetcode.com/problems/running-sum-of-1d-array/
public class _7RunningSumOf1DArray {

    public static int[] runningSum(int[] nums) {
        if (nums == null)
            return nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + Arrays.toString(runningSum(new int[]{1, 2, 1})));    //  yup: [1,3,4]
        System.out.println("yup: " + Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));    //  yup: [1, 3, 6, 10]
    }
}
