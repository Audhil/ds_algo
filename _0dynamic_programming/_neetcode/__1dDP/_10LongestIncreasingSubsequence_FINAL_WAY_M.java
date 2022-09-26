package _0dynamic_programming._neetcode.__1dDP;

import java.util.Arrays;

//  https://leetcode.com/problems/longest-increasing-subsequence/
//  https://www.youtube.com/watch?v=_i4Yxeh5ceQ&ab_channel=NeetCode
public class _10LongestIncreasingSubsequence_FINAL_WAY_M {

  //  O (n^2)
  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 1) {
      return 1;
    }

    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int maxSoFar = 0;
    //  iterate from back side
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        //  consider only if it is smaller  [1,2,3,44,5] - we should not choose 5 after 44
        if (nums[i] < nums[j]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]); //  https://youtu.be/_i4Yxeh5ceQ?t=9519
        }
      }
      maxSoFar = Math.max(maxSoFar, dp[i]);
    }
    return maxSoFar;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: lengthOfLIS: " + lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));  //  4
    System.out.println("yup: lengthOfLIS: " + lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));  //  4
    System.out.println("yup: lengthOfLIS: " + lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); //  1
  }
}
