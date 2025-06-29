package ds_algo._0dynamic_programming._3LCS;

//  https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22&ab_channel=AdityaVerma
public class _3LCString {

    /*
    * Longest Common Substring(Dynamic Programming)
        Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
        Examples:

        Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
        Output : 5
        The longest common substring is “Geeks” and is of length 5.
    * */

    private String a = "abcde";   //  whose length is i
    private String b = "ababcde";     //  whose length is j

//    private String a = "abcde";   //  whose length is i
//    private String b = "abfce";     //  whose length is j

//    private String a = "GeeksforGeeks";   //  whose length is i
//    private String b = "GeeksQuiz";     //  whose length is j

    private int longestCommonSubstring() {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        int[][] t = new int[aArray.length + 1][bArray.length + 1];

        for (int i = 0; i < aArray.length + 1; i++) {
            for (int j = 0; j < bArray.length + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (aArray[i - 1] == bArray[j - 1])
                    t[i][j] = 1 + (t[i - 1][j - 1]);
                else
                    t[i][j] = 0;
            }
        }

        int max = -1;
        for (int i = 0; i < aArray.length + 1; i++) {
            for (int j = 0; j < bArray.length + 1; j++) {
                max = Math.max(t[i][j], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        _3LCString prob = new _3LCString();
        System.out.println("yup: LC SubString: " + prob.longestCommonSubstring());
    }
}
