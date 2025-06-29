package _8InterviewBit.easy;

import java.util.Arrays;

//  expln: https://www.youtube.com/watch?v=XblA2DKBOSI&ab_channel=ProgrammersZone
public class _0BuildArrayFromPermutation {

    /*
    * Given a zero-based permutation nums (0-indexed), build an array ans of the same length
    * where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
      A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
      *
      * Example 1:

        Input: nums = [0,2,1,5,3,4]
        Output: [0,1,2,4,5,3]
        Explanation: The array ans is built as follows:
        ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
            = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
            = [0,1,2,4,5,3]
        Example 2:

        Input: nums = [5,0,1,2,3,4]
        Output: [4,5,0,1,2,3]
        Explanation: The array ans is built as follows:
        ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
            = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
            = [4,5,0,1,2,3]
    */

    //  TC: O(N); SC: O(1)
    public static int[] buildArray(int[] nums) {
        if (nums == null)
            return nums;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = n * (nums[nums[i]] % n) + nums[i];    //  this is the meat
        }
        for (int i = 0; i < n; i++) {
            nums[i] /= n;   //  num[i]/n = will give new value; num[i]%n = will give old value;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("yup: soln: " + Arrays.toString(buildArray(new int[]{0, 2, 1, 5, 3, 4})));
    }
}
