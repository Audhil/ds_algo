package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://youtu.be/9h10fqkI7Nk?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _5PalindromePartitioning_Memoization_Optimized {

    private String str = "ababbbabbababa";    //  a|babbbab|b|ababa - 3
//    private String str = "nitik"; //  n|iti|k - 2
//    private String str = "nitin"; //  0 - since nitin itself a palindrome

    private int[][] t = new int[1000 + 1][1000 + 1];   //  based on given contraints

    private int solve(String str, int i, int j) {
        if (i >= j)
            return 0;

        if (isPalindrome(str, i, j))
            return 0;

        if (t[i][j] != -1)
            return t[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left;
            if (t[i][k] != -1) {
                left = t[i][k];
            } else {
                left = solve(str, i, k);
                t[i][k] = left;
            }

            int right;
            if (t[k + 1][j] != -1) {
                right = t[k + 1][j];
            } else {
                right = solve(str, k + 1, j);
                t[k + 1][j] = right;
            }

            int tempAns = left  //  based on scheme
                    + right //  based on scheme
                    + 1; //  it's partition done, to make scheme separation
            if (min > tempAns)
                min = tempAns;
        }
        return t[i][j] = min;
    }

    private boolean isPalindrome(String str, int i, int j) {
        if (i == j)  //  if only 1 char is available in str, it's palindrome by default
            return true;

        if (i > j)   //  i passed j, it's empty str, hence it's palindrome by default
            return true;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private void preFill() {
        for (int row = 0; row < t.length; row++) {
            for (int col = 0; col < t[row].length; col++) {
                t[row][col] = -1;
            }
        }
    }

    public static void main(String[] args) {
        _5PalindromePartitioning_Memoization_Optimized prob = new _5PalindromePartitioning_Memoization_Optimized();
        int i = 0;  //  0 is allowed, since it's string, no prob of arr[-1] index issues here
        int j = prob.str.length() - 1;   //  last index
        prob.preFill();
        System.out.println("yup min partition needed to make each sec as palindrome: " + prob.solve(prob.str, i, j));
    }
}
