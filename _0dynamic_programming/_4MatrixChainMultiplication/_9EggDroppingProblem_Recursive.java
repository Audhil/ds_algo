package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://youtu.be/S49zeUjeUL0?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _9EggDroppingProblem_Recursive {

    /*
    * Egg Dropping using Recursion
        Problem statement: You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:

        If egg breaks at ith floor then it also breaks at all greater floors.
        If egg does not break at ith floor then it does not break at all lower floors.
        Unbroken egg can be used again.
        Note: You have to find minimum trials required to find the critical floor not the critical floor.

        Example:
        Input:
            4
            2

            Output:
            Number of trials when number of eggs is 2 and number of floors is 4: 3
     * */

    private int solve(int e, int f) {    //  eggs & floors
        if (f == 0 || f == 1)
            return f;

        if (e == 1)
            return f;

        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int tempAns = 1     //  it is attempt - 1
                    + Math.max( //  it is max - since we need to find minNoOfAttempts - so it is worst case
                    solve(e - 1, k - 1),    //  when egg is broken
                    solve(e, f - k)             //  when egg is not broken
            );
            min = Math.min(tempAns, min);   //  we need minNoOfAttempts
        }
        return min;
    }

    public static void main(String[] args) {
        _9EggDroppingProblem_Recursive prob = new _9EggDroppingProblem_Recursive();
        System.out.println("yup: minNoOfAttempts : " + prob.solve(2, 4));
    }
}
