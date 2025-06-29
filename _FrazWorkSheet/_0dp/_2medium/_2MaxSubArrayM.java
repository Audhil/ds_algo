package _FrazWorkSheet._0dp._2medium;

//  https://leetcode.com/problems/maximum-subarray/
public class _2MaxSubArrayM {

  //  TC: O(n)
  private static int maxSubArray(int[] nums) {
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
        "yup: _2MaxSubArrayM: " + maxSubArray(
            new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); //  yup: _2MaxSubArrayM: 6
  }
}
