package ds_algo._0dynamic_programming._3LCS;

//  https://youtu.be/-fx6aDxcWyg?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _7NoOfInsertionDeletionStringAtoStringB {

    //    private String str1 = "geeksforgeeks", str2 = "geeks";
    private String str1 = "heap", str2 = "pea";

    private void printMinDelInsert() {
        int lcsLength = lcsLength();
        System.out.println("yup: chars to delete in str1: " + (str1.length() - lcsLength));
        System.out.println("yup: chars to insert in str2: " + (str2.length() - lcsLength));
    }

    private int lcsLength() {
        int[][] t = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(
                            t[i - 1][j],
                            t[i][j - 1]
                    );
            }
        }
        return t[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        _7NoOfInsertionDeletionStringAtoStringB prob = new _7NoOfInsertionDeletionStringAtoStringB();
        prob.printMinDelInsert();
    }
}
