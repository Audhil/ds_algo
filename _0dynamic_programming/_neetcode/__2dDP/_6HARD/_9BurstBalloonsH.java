package _0dynamic_programming._neetcode.__2dDP._6HARD;

//  https://youtu.be/qMky6D6YtXU?t=8879
public class _9BurstBalloonsH {

  //  TC for brute force: O (n^n)
  //  TC: O (n^3) => (subArray TC: O (n^2) * Iterate the whole array once O (n)) & SC: O (n^2)
  //  tip: arr with n items, will have n^2 sub arrays, 2^n sub sequences
  public static int maxCoins(int[] nums) {
    int[][] dp = new int[nums.length][nums.length];
    int l = 0, r = nums.length - 1;
    return burstBalloons(l, r, nums, dp);
  }

  private static int burstBalloons(int left, int right, int[] nums, int[][] dp) {
    if (left > right) {
      return 0;
    }
    if (dp[left][right] != 0) {
      return dp[left][right];
    }
    for (int i = left; i <= right; i++) {
      int coins = nums[i];
      if (left - 1 >= 0) {
        coins *= nums[left - 1];
      }
      if (right + 1 < nums.length) {
        coins *= nums[right + 1];
      }
      coins +=
          //  pop left sub array
          burstBalloons(left, i - 1, nums, dp)
              //  pop right sub array
              + burstBalloons(i + 1, right, nums, dp);
      dp[left][right] = Math.max(dp[left][right], coins);
    }
    return dp[left][right];
  }

  public static void main(String[] args) {
    System.out.println("yup: max no of coins: " + maxCoins(new int[]{3, 1, 5, 8})); //  yup: max no of coins: 167
    System.out.println("yup: max no of coins: " + maxCoins(new int[]{1, 5})); //  yup: max no of coins: 10
  }
}
