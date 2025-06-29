package ds_algo._0dynamic_programming._3LCS;

//  https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=19&ab_channel=AdityaVerma
public class _0LCSRecursiveApproach {

    private char[] a = {'a', 'c', 'e', 'f', 'h'};   //  whose length is n
    private char[] b = {'a', 'b', 'd', 'r', 'h'};     //  whose length is m

    private int longestCommonSubsequence(char[] a, char[] b, int n, int m) {
        //  base condition
        if (n == 0 || m == 0)
            return 0;

        //  choice diagram - iterating from back
        if (a[n - 1] == b[m - 1])
            return longestCommonSubsequence(a, b, n - 1, m - 1) + 1;    //  leave last item, move to other items & increment LCS count by 1
        else
            return Math.max(
                    longestCommonSubsequence(a, b, n, m - 1),   //  either remove last item of b array
                    longestCommonSubsequence(a, b, n - 1, m)    //  either remove last item of a array
            );
    }

    public static void main(String[] args) {
        _0LCSRecursiveApproach prob = new _0LCSRecursiveApproach();
        System.out.println("yup: LCS: " + prob.longestCommonSubsequence(prob.a, prob.b, prob.a.length, prob.b.length));
    }
}
