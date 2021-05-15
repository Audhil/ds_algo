package ds_algo._0dynamic_programming._3LCS;

//  https://youtu.be/QVntmksK2es?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _11SequencePatternMatching {

    //  tip point: LCS can be in range(0, min(m, n)) -> where m - is length of string a, n - is length of string b

    private String a = "axy";
    private String b = "adxcpy";

    private boolean isSequencePresentInString() {
        int[][] t = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(
                            t[i - 1][j],
                            t[i][j - 1]
                    );
                }
            }
        }
        if (t[a.length()][b.length()] == a.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        _11SequencePatternMatching prob = new _11SequencePatternMatching();
        System.out.println("yup: is Sequence is available: " + prob.isSequencePresentInString());
    }
}
