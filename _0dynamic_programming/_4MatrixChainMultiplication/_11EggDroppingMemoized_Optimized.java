package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://youtu.be/jkygQmOiCCI?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _11EggDroppingMemoized_Optimized {

    private int[][] t = new int[100 + 1][100 + 1]; //  by given constraints

    private void preFill() {
        for (int row = 0; row < t.length; row++) {
            for (int col = 0; col < t[row].length; col++) {
                t[row][col] = -1;
            }
        }
    }

    private int solve(int e, int f) {    //  eggs & floors
        if (f == 0 || f == 1)
            return f;

        if (e == 1)
            return f;

        if (t[e][f] != -1)
            return t[e][f];

        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int low;
            if (t[e - 1][k - 1] != -1)
                low = t[e - 1][k - 1];
            else
                low = solve(e - 1, k - 1);

            int high;
            if (t[e][f - k] != -1)
                high = t[e][f - k];
            else
                high = solve(e, f - k);
            int tempAns = 1     //  it is attempt - 1
                    + Math.max( //  it is max - since we need to find minNoOfAttempts - so it is worst case
                    low,    //  when egg is broken
                    high             //  when egg is not broken
            );
            min = Math.min(tempAns, min);   //  we need minNoOfAttempts
        }
        return t[e][f] = min;
    }

    public static void main(String[] args) {
        _11EggDroppingMemoized_Optimized prob = new _11EggDroppingMemoized_Optimized();
        prob.preFill();
        System.out.println("yup: minNoOfAttempts : " + prob.solve(2, 4));
    }
}
