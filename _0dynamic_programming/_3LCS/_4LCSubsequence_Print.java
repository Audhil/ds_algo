package ds_algo._0dynamic_programming._3LCS;

//  https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23&ab_channel=AdityaVerma
public class _4LCSubsequence_Print {

    private String a = "acbcf";   //  whose length is i
    private String b = "abcdaf";     //  whose length is j

    private int[][] lcsMatrixTable() {
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
                    t[i][j] = Math.max(
                            t[i - 1][j],
                            t[i][j - 1]
                    );
            }
        }

        for (int i = 0; i < aArray.length + 1; i++) {
            for (int j = 0; j < bArray.length + 1; j++) {
                System.out.print(" " + t[i][j] + " ");
            }
            System.out.println();
        }

        return t;
    }

    private String printLCS() {
        int[][] matrix = lcsMatrixTable();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        int i = aArray.length, j = bArray.length;

        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (aArray[i - 1] == bArray[j - 1]) {
                stringBuilder.append(aArray[i - 1]);
                i--;
                j--;
            } else {
                if (matrix[i][j - 1] > matrix[i - 1][j])
                    j--;
                else
                    i--;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        _4LCSubsequence_Print prob = new _4LCSubsequence_Print();
        System.out.println("yup: LCS is : " + prob.printLCS());
    }
}
