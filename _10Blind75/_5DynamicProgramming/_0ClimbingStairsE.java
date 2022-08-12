package _10Blind75._5DynamicProgramming;

//  COVERED ALL FORMS OF CLIMBING STAIRS PROBLEM - refer: _0Basic_Recursion_1_climbing_stairs.java
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

  //  climb stairs with recursion - user can take 1 step or 2 step at a time - memoization possible
  private static int climbStairsWithRecursion(int stepNo, int dest) {
    //  reached top
    if (stepNo == dest) {
      return 1;
    }
    //  invalid case
    if (stepNo > dest) {
      return 0;
    }

    return climbStairsWithRecursion(stepNo + 1, dest) + climbStairsWithRecursion(stepNo + 2, dest);
  }

  //  from top to floor - memoization possible
  private static int climbDownStairsWithRecursion(int dest) {
    //  reached floor
    if (dest == 0) {
      return 1;
    }
    //  invalid case
    if (dest < 0) {
      return 0;
    }
    return climbDownStairsWithRecursion(dest - 1) + climbDownStairsWithRecursion(dest - 2);
  }

  //  climb with min cost - iterative
  private static int climbStairsWithMinCostIterative(int[] cost) {
    if (cost == null || cost.length < 2) {
      return 0;
    }
    int[] soln = new int[cost.length + 1];
    soln[0] = 0;
    soln[1] = cost[0];  //  cost[0] is the cost to reach 1st step
    for (int i = 2; i < soln.length; i++) {
      soln[i] = Math.min(soln[i - 1], soln[i - 2]) + cost[i - 1];
    }
    return soln[soln.length - 1];
  }

  //  climb with min cost - recursive
  private static int climbStairsWithMinCostRecursive(int stepNo, int dest, int[] cost) {
    if (stepNo == dest - 1) {
      return cost[stepNo];
    }

    int op = climbStairsWithMinCostRecursive(stepNo + 1, dest, cost);
    if (stepNo + 2 <= dest - 1) {
      op = Math.min(op, climbStairsWithMinCostRecursive(stepNo + 2, dest, cost));
    }
    return cost[stepNo] + op;
  }

  public static void main(String[] args) {
    System.out.println("yup: ways to climb: " + climbStairs(4));  //  5 ways
    System.out.println("yup: ways to climbStairsWithoutDP: " + climbStairsWithoutDP(2));  //  2 ways
    System.out.println(
        "yup: ways to climbStairsWithRecursion: " + climbStairsWithRecursion(1, 4));  //  5 ways
    System.out.println(
        "yup: ways to climbStairsWithRecursion: " + climbStairsWithRecursion(0, 2));  //  2 ways
    System.out.println("yup: ways to climbDownStairsWithRecursion: " + climbDownStairsWithRecursion(
        4));  //  5 ways
    System.out.println("yup: ways to climbDownStairsWithRecursion: " + climbDownStairsWithRecursion(
        2));  //  2 ways
    System.out.println("yup: climbStairsWithMinCostIterative: " + climbStairsWithMinCostIterative(
        new int[]{10, 15, 20}));    //  yup: minCost: 30
    System.out.println("yup: climbStairsWithMinCostIterative: " + climbStairsWithMinCostIterative(
        new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));    //  yup: minCost: 6
    System.out.println(
        "yup: climbStairsWithMinCostRecursive: " + climbStairsWithMinCostRecursive(0, 3,
            new int[]{10, 15, 20}));    //  yup: minCost: 30
    System.out.println(
        "yup: climbStairsWithMinCostRecursive: " + climbStairsWithMinCostRecursive(0, 10,
            new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));    //  yup: minCost: 6
  }
}
