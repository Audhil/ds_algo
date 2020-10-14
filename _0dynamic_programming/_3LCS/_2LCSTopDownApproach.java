package ds_algo._0dynamic_programming._3LCS;

//  https://www.youtube.com/watch?v=hR3s9rGlMTU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=21&ab_channel=AdityaVerma
public class _2LCSTopDownApproach {

    private char[] a = "AGGTAB".toCharArray();   //  whose length is i
    private char[] b = "GXTXAYB".toCharArray();     //  whose length is j

    private int lcs() {
        int[][] t = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; i++) {
            for (int j = 0; j < b.length + 1; j++) {
                //  initialization
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                    //  choice diagram
                    //  if matching
                else if (a[i - 1] == b[j - 1])
                    t[i][j] = (t[i - 1][j - 1]) + 1;
                    //  if not matching
                else
                    t[i][j] = Math.max(
                            t[i - 1][j],
                            t[i][j - 1]
                    );
            }
        }

        for (int i = 0; i < a.length + 1; i++) {
            for (int j = 0; j < b.length + 1; j++) {
                System.out.print(" " + t[i][j] + " ");
            }
            System.out.println();
        }

        return t[a.length][b.length];
    }

    public static void main(String[] args) {
        _2LCSTopDownApproach prob = new _2LCSTopDownApproach();
        System.out.println("yup: LCS top-down approach: " + prob.lcs());
    }
}
