package ds_algo._0dynamic_programming._1_01KnapSack;

//  https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12&ab_channel=AdityaVerma
//  this prob is equal  to  CountOfSubsetSumWithGivenDiff - refer _7CountOfSubsetsSumWithGivenDiff.java
public class _8TargetSum {

    /*
    * Target Sum Problem
        Given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

        Find out how many ways to assign symbols to make sum of integers equal to target S.

        Example 1:
        Input: nums is [1, 1, 1, 1, 1], S is 3.
        Output: 5
        Explanation:

        -1+1+1+1+1 = 3
        +1-1+1+1+1 = 3
        +1+1-1+1+1 = 3
        +1+1+1-1+1 = 3
        +1+1+1+1-1 = 3

        There are 5 ways to assign symbols to make the sum of nums be target 3.

        PROBLEM STATEMENT LINK:https://leetcode.com/problems/target-...
    * */

//    i/p - 1
//    private int[] arr = {1, 1, 2, 3};
//    private int targetSum = 1;

    //    i/p - 2
    private int[] arr = {1, 1, 1, 1, 1};
    private int targetSum = 3;

    private int targetSum() {
        return countOfSubsetsSumWithGivenDiff();
    }

    private int countOfSubsetsSumWithGivenDiff() {
        int sumOfArray = 0;
        for (int i = 0; i < arr.length; i++)
            sumOfArray += arr[i];
        int sum1 = (targetSum + sumOfArray) / 2;
        return noOfSubsetsWithSum(arr, sum1);
    }

    private int noOfSubsetsWithSum(int[] arr, int sum) {
        int[][] t = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                //  initialization
                if (i == 0 && j == 0)
                    t[i][j] = 1;
                else if (i == 0)
                    t[i][j] = 0;
                else if (j == 0)
                    t[i][j] = 1;
                    //  choice diagram
                else if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]]
                            +
                            t[i - 1][j];
                else if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        _8TargetSum prob = new _8TargetSum();
        System.out.println("yup: on adding signs to each item, targetSum Is: " + prob.targetSum());
    }
}
