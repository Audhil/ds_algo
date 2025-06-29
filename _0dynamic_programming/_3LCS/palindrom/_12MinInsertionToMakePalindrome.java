package ds_algo._0dynamic_programming._3LCS.palindrom;

//  https://youtu.be/AEcRW4ylm_c?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _12MinInsertionToMakePalindrome {

    //  no of chars to insert = no of chars to delete, to make a string palindrome
    private String a = "aebcbda";

    private int noOfCharsToDeleteToMakePalindrome() {
        int palindromeLength = lcsLength(a, new StringBuilder(a).reverse().toString());
        return a.length() - palindromeLength;
    }

    private int lcsLength(String a, String b) {
        int[][] t = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
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
        _12MinInsertionToMakePalindrome prob = new _12MinInsertionToMakePalindrome();
        int noOfCharsInsertionToMakePalindrome = prob.noOfCharsToDeleteToMakePalindrome();
        System.out.println("yup: noOfCharsInsertionToMakePalindrome: " + noOfCharsInsertionToMakePalindrome);
    }
}
