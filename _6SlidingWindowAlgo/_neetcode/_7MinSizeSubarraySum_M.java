package _6SlidingWindowAlgo._neetcode;

//  https://leetcode.com/problems/minimum-size-subarray-sum/
public class _7MinSizeSubarraySum_M {

  //  TC: O (n); SC: O (1)
  public static int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int l = 0;
    int totalTillNow = 0;
    int res = Integer.MAX_VALUE;
    for (int r = 0; r < n; r++) {
      totalTillNow += nums[r];
      while (totalTillNow >= target) {
        res = Math.min(res, r - l + 1);
        totalTillNow -= nums[l];
        l++;
      }
    }
    if (res == Integer.MAX_VALUE) {
      return 0;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: min sub array: " + minSubArrayLen(7,
        new int[]{2, 3, 1, 2, 4, 3}));  //  yup: min sub array: 2
    System.out.println(
        "yup: min sub array: " + minSubArrayLen(4, new int[]{1, 4, 4})); //  yup: min sub array: 1
    System.out.println(
        "yup: min sub array: " + minSubArrayLen(11,
            new int[]{1, 1, 1, 1, 1, 1, 1, 1}));  //  yup: min sub array: 0
  }
}
