package ds_algo._0dynamic_programming._3LCS;

//  https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26&ab_channel=AdityaVerma
public class _8LongestPalindromicSubsequence {

    //  tip point: LPS = LCS(a, reverse(a))

    private String a = "agbcba";

    private LCSClass longestPalindromicSubsequence() {
        String b = new StringBuilder(a).reverse().toString();   //  if only 1 str is given, just reverse it to get LPS
        return lcsTopDownApproach(a, b);
    }

    private LCSClass lcsTopDownApproach(String a, String b) {
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
        return new LCSClass(t[a.length()][b.length()], t);
    }

    private String printPalindromeSequence(String a, String b, int[][] matrix) {
        int i = a.length();
        int j = b.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                stringBuilder.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (matrix[i - 1][j] > matrix[i][j - 1])
                    i--;
                else
                    j--;
            }
        }
        return stringBuilder.reverse().toString();
    }

    private class LCSClass {
        private int lcsLength;
        private int[][] lcsMatrix;

        public LCSClass(int lcsLength, int[][] lcsMatrix) {
            this.lcsLength = lcsLength;
            this.lcsMatrix = lcsMatrix;
        }
    }

    public static void main(String[] args) {
        _8LongestPalindromicSubsequence prob = new _8LongestPalindromicSubsequence();
        LCSClass lcsClass = prob.longestPalindromicSubsequence();
        System.out.println("yup: length of LPS: " + lcsClass.lcsLength);
        System.out.println("yup: palindrome is : " + prob.printPalindromeSequence(
                prob.a,
                new StringBuilder(prob.a).reverse().toString(),
                lcsClass.lcsMatrix));
    }
}
