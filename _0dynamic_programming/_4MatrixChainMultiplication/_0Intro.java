package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://www.youtube.com/watch?v=D7AFvtnDeMU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=33&ab_channel=AdityaVerma
public class _0Intro {

    //  format
    private int solve(int[] arr, int i, int j) {
        if (i > j)
            return 0;

        int ans = 0;
        for (int k = i; k < j; k++) {
            int tempAns = solve(arr, i, k) + solve(arr, k + 1, j);  //  +, - will depend on question
            ans = func(tempAns);
        }
        return ans;
    }

    private int func(int tempAns) {
        //  do some function here
        return 0;
    }
}
