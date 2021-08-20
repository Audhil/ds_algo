package _0easy;

//  https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

    //  top down & bottom up approach
    //  https://www.youtube.com/watch?v=NFJ3m9a1oJQ

    //  https://www.youtube.com/watch?v=uHAToNgAPaM
    private static int climbStairsWithDP(int n) {
        if (n == 0 || n == 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;  //  0 steps - no of ways to climb = 1
        dp[1] = 1;  //  1 step - no of ways to climb = 1

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];   //  no of ways to climb ith step = i -1 (climbing from 1 step) + i - 2(climbing from 2 steps)
        }
        return dp[n];
    }

    public static int climbStairs(int n) {
        if (n < 2)
            return n;

        int n1 = 1, n2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = n1;
            n1 = n1 + n2;
            n2 = temp;
        }
        return n1 + n2;
    }

    public static void main(String[] args) {
        System.out.println("yup: ClimbingStairs: " + climbStairs(4));
        System.out.println("yup: climbStairsWithDP: " + climbStairsWithDP(4));
    }
}
