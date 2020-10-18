package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=35&ab_channel=AdityaVerma
public class _2MCM_Memoization_Bottom_Up {

    private int[][] t = new int[100 + 1][100 + 1];   //  based on given contraints

    private int[] arr = {40, 20, 30, 10, 30};

    private int solve(int[] arr, int i, int j) {
        if (i >= j)
            return 0;

        if (t[i][j] != -1)
            return t[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int tempAns = solve(arr, i, k)  //  (A * B)
                    + solve(arr, k + 1, j)  //  (B * C)
                    + arr[i - 1] * arr[k] * arr[j]; //  (A * B) * (B * C)
            if (min > tempAns)
                min = tempAns;
        }
        return t[i][j] = min;
    }

    private void initArray() {
        for (int row = 0; row < t.length; row++) {
            for (int col = 0; col < t[row].length; col++) {
                t[row][col] = -1;
            }
        }
    }

    public static void main(String[] args) {
        _2MCM_Memoization_Bottom_Up prob = new _2MCM_Memoization_Bottom_Up();
        prob.initArray();
        int i = 1;
        int j = prob.arr.length - 1;
        System.out.println("yup: with memoization mcm: min : " + prob.solve(prob.arr, i, j));
    }
}
