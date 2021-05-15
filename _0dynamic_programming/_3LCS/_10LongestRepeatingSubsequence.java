package ds_algo._0dynamic_programming._3LCS;

//  https://youtu.be/hbTaCmQGqLg?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _10LongestRepeatingSubsequence {

    /*
    * Longest Repeating Subsequence
        Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
        Example:
        Input: str = "aab"
        Output: "a"
        The two subsequence are 'a'(first) and 'a'
        (second). Note that 'b' cannot be considered
        as part of subsequence as it would be at same
        index in both.
        * */

    private String str = "aabebcdd";

    private int findLongestRepeatingSubsequence() {
        //  we'll take same string 2 times & find LCS
        int[][] t = new int[str.length() + 1][str.length() + 1];
        for (int i = 0; i < str.length() + 1; i++) {
            for (int j = 0; j < str.length() + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (str.charAt(i - 1) == str.charAt(j - 1)
                        && i != j)
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(
                            t[i - 1][j],
                            t[i][j - 1]
                    );
            }
        }
        return t[str.length()][str.length()];
    }

    public static void main(String[] args) {
        _10LongestRepeatingSubsequence prob = new _10LongestRepeatingSubsequence();
        System.out.println("yup LongestRepeatingSubsequence: " + prob.findLongestRepeatingSubsequence());
    }
}
