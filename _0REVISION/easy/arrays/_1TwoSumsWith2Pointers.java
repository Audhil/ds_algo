package _0REVISION.easy.arrays;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=S5S1oaD3KiM\
//  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
//  with 2 pointer technique
public class _1TwoSumsWith2Pointers {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null)
            return null;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target)
                j--;
            else if (nums[i] + nums[j] < target)
                i++;
            else
                return new int[]{i + 1, j + 1};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println("yup: two sum II : " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        //  yup: two sum II : [1, 2]
    }
}
