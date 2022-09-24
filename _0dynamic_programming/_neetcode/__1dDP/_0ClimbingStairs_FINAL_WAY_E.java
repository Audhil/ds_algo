package _0dynamic_programming._neetcode.__1dDP;

//  https://youtu.be/_i4Yxeh5ceQ?t=151
public class _0ClimbingStairs_FINAL_WAY_E {

  //  TC: O (n) we achieved through dp, it not it'll be O (2^n) -> since height of the binary tree in n - https://youtu.be/_i4Yxeh5ceQ?t=529
  //  num of steps to reach top from floor - only 1 step or 2 steps allowed
  //  using bottom up approach
  public static int climbStairs(int n) {
    int[] dp = new int[n + 1];
    //  we are in top, how many ways to reach the top, that is always 1
    dp[n] = 1;
    //  we are in 1 step below top, how many ways to reach the top, it is 1, we cannot take 2, since it'll out of bound
    dp[n - 1] = 1;
    //  calculating from top to bottom
    for (int i = n - 2; i >= 0; i--) {
      //  how many ways to reach the top from ith step,
      //  take 1 step to reach i+1, 2 steps to reach i+2,
      //  then we'll compute num of ways to reach top from  either i+1, i+2 steps
      dp[i] = dp[i + 1] + dp[i + 2];
    }
    return dp[0]; //  hence num of steps needed to reach top from floor
  }

  //  beautiful code from neetcode, without extra memory
  //  based on fibanacci series idea
  public static int climbStairsNeetCode(int n) {
    int one = 1, two = 1, temp;
    for (int i = 0; i < n - 1; i++) {
      temp = one;
      one += two;
      two = temp;
    }
    return one;
  }

  public static void main(String[] args) {
    System.out.println("yup: num of ways to reach top with steps : 5: is : "
        + climbStairs(5)); //  yup: num of ways to reach top with steps : 5: is : 8

    System.out.println("yup: num of ways to reach top with steps : 5: is : "
        + climbStairsNeetCode(5)); //  yup: num of ways to reach top with steps : 5: is : 8
  }
}
