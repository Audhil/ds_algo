package ds_algo._0dynamic_programming._3LCS;

//  https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28&ab_channel=AdityaVerma
public class _9MinDeletionToMakePalindrome {

    //  tip point: min del = str(len) - lps(len)

    private String a = "agbcba";

    private int longestPalindromicSubsequence() {
        String b = new StringBuilder(a).reverse().toString();   //  if only 1 str is given, just reverse it to get LPS
        return lcsLengthTopDownApproach(a, b);
    }

    private int lcsLengthTopDownApproach(String a, String b) {
        int[][] t = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
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
        _9MinDeletionToMakePalindrome prob = new _9MinDeletionToMakePalindrome();
        int palindromLength = prob.longestPalindromicSubsequence();
        int strLen = prob.a.length();
        System.out.println("yup: min deletion: str(len) - lps(len) : " + (strLen - palindromLength));
    }
}
