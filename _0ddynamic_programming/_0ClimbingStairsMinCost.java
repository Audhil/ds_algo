package _0ddynamic_programming;

//  https://www.youtube.com/watch?v=hoQ51U2OeaI&list=PLNxqWc8Uj2LRX8GaMJFeRE0Nx5gLBxBBX&index=2
//  https://leetcode.com/problems/min-cost-climbing-stairs/

//  TC: O(n), SC: O(1)
public class _0ClimbingStairsMinCost {

    //  with bottom up approach
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2)
            return 0;

        for (int i = 2; i < cost.length; i++)
            cost[i] += Math.min(cost[i - 2], cost[i - 1]);

        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println("yup: minCost: " + minCostClimbingStairs(new int[]{10, 15, 20}));    //  yup: minCost: 15
        System.out.println("yup: minCost: " + minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));    //  yup: minCost: 6
    }
}
