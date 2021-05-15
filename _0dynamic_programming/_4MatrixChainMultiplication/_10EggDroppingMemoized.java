package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://youtu.be/gr2NtY-2QUY?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _10EggDroppingMemoized {
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
            int tempAns = 1     //  it is attempt - 1
                    + Math.max( //  it is max - since we need to find minNoOfAttempts - so it is worst case
                    solve(e - 1, k - 1),    //  when egg is broken
                    solve(e, f - k)             //  when egg is not broken
            );
            min = Math.min(tempAns, min);   //  we need minNoOfAttempts
        }
        return t[e][f] = min;
    }

    public static void main(String[] args) {
        _10EggDroppingMemoized prob = new _10EggDroppingMemoized();
        prob.preFill();
        System.out.println("yup: minNoOfAttempts : " + prob.solve(2, 4));
    }
}
