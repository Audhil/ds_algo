package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://www.youtube.com/watch?v=D7AFvtnDeMU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=33&ab_channel=AdityaVerma
public class _0Intro {

    /*
    steps,
    1. choose i, j values
    2. make base condition
    3. points to note, schemes
     * 1. take i from index 1 to support -> a(i) = a(i-1) * a(i), and take j at last index
     * 2. take k from,
     *   a)  from k=i to k=j-1, break func(i to k) & func(k+1 to j)
     *   b)  from k=i+1 to k=j, break func(i to k-1) & func(k to j)
     * */

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
