package _10Blind75._6GreedyApproach._jumpGames;

//  https://www.youtube.com/watch?v=pQXbujZLTv0&ab_channel=AlgorithmsMadeEasy
//  https://leetcode.com/problems/jump-game-v/
public class _05JumpGameV_H {

  public static int maxJumps(int[] arr, int d) {
    int maxJumps = Integer.MIN_VALUE;
    int[] dp = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      maxJumps = Math.max(maxJumps, helper(i, d, arr, dp));
    }
    return maxJumps;
  }

  private static int helper(int index, int d, int[] arr, int[] dp) {
    if (dp[index] > 0) {
      return dp[index];
    }
    int result = 1; //  we are standing on an index, we reached here only after jumping from other place
    //  index - 1 ... index - d; - moving left side
    for (int i = index - 1; i >= Math.max(index - d, 0) && arr[index] > arr[i]; i--) {
      result = Math.max(result, 1 + helper(i, d, arr, dp));
    }
    //  index +1 ... index + d; - moving right side
    for (int i = index + 1; i <= Math.min(index + d, arr.length - 1) && arr[index] > arr[i]; i++) {
      result = Math.max(result, 1 + helper(i, d, arr, dp));
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: max jumps from : " + maxJumps(new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, 2));  //  4
    System.out.println(
        "yup: max jumps from : " + maxJumps(new int[]{3, 3, 3, 3, 3}, 3));  //  1
    System.out.println(
        "yup: max jumps from : " + maxJumps(new int[]{7, 6, 5, 4, 3, 2, 1}, 1));  //  7
  }
}
