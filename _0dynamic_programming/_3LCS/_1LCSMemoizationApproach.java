package ds_algo._0dynamic_programming._3LCS;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=g_hIx4yn9zg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=20&ab_channel=AdityaVerma
public class _1LCSMemoizationApproach {

    private char[] a = {'a', 'c', 'e', 'f', 'h'};   //  whose length is n
    private char[] b = {'a', 'b', 'd', 'r', 'h'};     //  whose length is m

    private int[][] t = new int[100 + 1][100 + 1];  //  based on given constraints

    private void preFill() {
        for (int row = 0; row < t.length; row++) {
            for (int col = 0; col < t[row].length; col++) {
                t[row][col] = -1;
            }
        }
    }

    private int longestCommonSubsequence(char[] a, char[] b, int n, int m) {
        //  base condition
        if (n == 0 || m == 0)
            return 0;

        if (t[n][m] != -1)
            return t[n][m];

        //  choice diagram
        if (a[n - 1] == b[m - 1])
            return t[n][m] = longestCommonSubsequence(a, b, n - 1, m - 1) + 1;
        else
            return t[n][m] = Math.max(
                    longestCommonSubsequence(a, b, n, m - 1),   //  either remove last item of b array
                    longestCommonSubsequence(a, b, n - 1, m)    //  either remove last item of a array
            );
    }

    public static void main(String[] args) {
        _1LCSMemoizationApproach prob = new _1LCSMemoizationApproach();
        prob.preFill();
        System.out.println("yup: LCS with Memoized: " + prob.longestCommonSubsequence(prob.a, prob.b, prob.a.length, prob.b.length));
    }
}
