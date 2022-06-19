package _10Blind25._0Arrays;

//  https://leetcode.com/problems/maximum-subarray/
//  explanation: https://www.youtube.com/watch?v=5WZl3MMT0Eg&ab_channel=NeetCode
public class _7MaxSubarrayE {

  public static int maxSubArray(int[] nums) {
    if (nums == null) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int maxSum = 0, currSum = 0;
    for (int num : nums) {
      if (currSum < 0) {
        currSum = 0;
      }
      currSum += num;
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: Max sum of SubArray: " + maxSubArray(
            new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));  //  yup: Max sum of SubArray: 6
    System.out.println(
        "yup: Max sum of SubArray: " + maxSubArray(new int[]{1}));  //  yup: Max sum of SubArray: 1
    System.out.println(
        "yup: Max sum of SubArray: " + maxSubArray(new int[]{-1})); //  yup: Max sum of SubArray: -1
    System.out.println(
        "yup: Max sum of SubArray: " + maxSubArray(
            new int[]{5, 4, -1, 7, 8})); //  yup: Max sum of SubArray: 23
  }
}
