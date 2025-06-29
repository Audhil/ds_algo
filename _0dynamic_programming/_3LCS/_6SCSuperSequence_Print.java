package ds_algo._0dynamic_programming._3LCS;

//  https://youtu.be/VDhRg-ZJTuc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _6SCSuperSequence_Print {

    private String a = "aggtab";
    private String b = "gxtxayb";

    private int[][] lCSubSequence() {
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
        return t;
    }

    private String printSCS() {
        int[][] matrix = lCSubSequence();
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                System.out.print(" " + matrix[row][col] + " ");
//            }
//            System.out.println();
//        }
        int i = a.length();
        int j = b.length();

        StringBuilder stringBuilder = new StringBuilder();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                stringBuilder.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (matrix[i - 1][j] > matrix[i][j - 1]) {
                    stringBuilder.append(a.charAt(i - 1));
                    i--;
                } else {
                    stringBuilder.append(b.charAt(j - 1));
                    j--;
                }
            }
        }

        //  add remaining chars too
        while (i > 0) {
            stringBuilder.append(a.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            stringBuilder.append(b.charAt(j - 1));
            j--;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        _6SCSuperSequence_Print prob = new _6SCSuperSequence_Print();
        System.out.println("yup: SCS is : " + prob.printSCS());
    }
}
