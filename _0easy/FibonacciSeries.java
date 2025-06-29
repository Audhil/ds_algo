package _0easy;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=PVrjDcj4uno&list=PLNxqWc8Uj2LRX8GaMJFeRE0Nx5gLBxBBX&index=4
public class FibonacciSeries {

    //  top down approach: TC = O(2^n) & SC: O(n)
    private static int fib(int n) {
        if (n == 0 || n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    //  top down with dp(memoization) - reducing TC: O(n) & SC: O(n)
    private static int fibWithMemoization(int n, int[] dp) {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fib(n - 1) + fib(n - 2);
    }

    //  bottom up approach - the iterative approach. TC: O(n) & SC: O(n)
    private static int fibWithBottomUp(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //  bottom up approach - the iterative approach. TC: O(n) & SC: O(1)
    private static int fibWithBottomUpSpaceOptimized(int n) {
        if (n == 0)
            return 0;
        int x = 1;
        int y = 1;
        for (int i = 2; i <= n; i++) {
            int temp = x + y;
            x = y;
            y = temp;
        }
        return y;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("yup: top down fibonacci: " + fib(n));    //  yup: fibonacci: 5
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("yup top down with memoization fibonacci: " + fibWithMemoization(n, dp));  //  yup fibonacci: 5
        System.out.println("yup bottom up fibonacci: " + fibWithBottomUp(n));  //  yup fibonacci: 5
        System.out.println("yup bottom up fibWithBottomUpSpaceOptimized: " + fibWithBottomUpSpaceOptimized(n));  //  yup fibonacci: 5
    }
}
