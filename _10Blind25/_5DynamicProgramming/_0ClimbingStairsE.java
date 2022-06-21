package _10Blind25._5DynamicProgramming;

//  https://www.youtube.com/watch?v=uHAToNgAPaM&ab_channel=KevinNaughtonJr.
public class _0ClimbingStairsE {

  //  with dynamic prog
  public static int climbStairs(int n) {
    if (n <= 1) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;  //  not climbing, be at ground level
    dp[1] = 1;  //  ways to climb, 1 step
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i
          - 2];  //  ways to reach ith floor = take 1 step reach + take 2 steps to reach
    }
    return dp[n];
  }

  private static int climbStairsWithoutDP(int n) {
    if (n <= 1) {
      return n;
    }
    int s1 = 1, s2 = 1, temp;
    for (int i = 2; i <= n; i++) {
      temp = s1;
      s1 += s2;
      s2 = temp;
    }
    return s1;
  }

  public static void main(String[] args) {
    System.out.println("yup: ways to climb: " + climbStairs(4));
    System.out.println("yup: ways to climbStairsWithoutDP: " + climbStairsWithoutDP(2));
  }
}
