package ds_algo._0dynamic_programming._3LCS;

//  https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24&ab_channel=AdityaVerma
public class _5ShortestCommonSuperSequence {

    /*
    * Shortest Common Supersequence
        Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
        Examples:

        Input:   str1 = "geek",  str2 = "eke"
        Output: "geeke"

        PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/shortest-common-supersequence/
    * */

    private String a = "aggtab";
    private String b = "gxtxayb";

    private int shortestCommonSuperSequence() {
        int m = a.length();
        int n = b.length();
        return (m + n) - lCSubSequence();
    }

    private int lCSubSequence() {
        int[][] t = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                //  initialization
                if (i == 0 || j == 0)
                    t[i][j] = 0;

                    //  choice diagram
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(
                            t[i - 1][j],
                            t[i][j - 1]
                    );
            }
        }
        return t[a.length()][b.length()];
    }

    public static void main(String[] args) {
        _5ShortestCommonSuperSequence prob = new _5ShortestCommonSuperSequence();
        System.out.println("yup: shortestCommonSuperSequence: " + prob.shortestCommonSuperSequence());
    }
}
