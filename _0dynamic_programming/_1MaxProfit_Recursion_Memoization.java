package ds_algo._0dynamic_programming;

//  THIS IS 0 1 knapSack problem
public class _1MaxProfit_Recursion_Memoization {

    //  https://www.youtube.com/watch?v=fJbIuhs24zQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4&ab_channel=AdityaVerma

    private int[] valArray = new int[]{7, 2, 11, 77};
    private int[] wtArray = new int[]{1, 12, 1, 7};
    private int maxWeight = 6; //  max weight a knapsack can hold

    //  constraints - n  <= 100, W <= 1000 - we'll create matrix of W & n, since they are getting changed every time
    //  memoize array let us say 't'
    private int[][] t = new int[100 + 1][1000 + 1];     //  based on given constraint

    private void preFill() {
        for (int row = 0; row < t.length; row++) {
            for (int col = 0; col < t[row].length; col++) {
                t[row][col] = -1;
            }
        }
    }

    private int knapSack(int[] valArray, int[] wtArray, int W, int n) {
        //  base condition
        if (W == 0 || n == 0)
            return 0;

        if (t[n][W] != -1)
            return t[n][W];

        //  choice diagram
        if (wtArray[n - 1] <= W)
            return t[n][W] = Math.max(
                    valArray[n - 1] + knapSack(valArray, wtArray, W - wtArray[n - 1], n - 1),
                    knapSack(valArray, wtArray, W, n - 1)
            );
        else if (wtArray[n - 1] > W)
            return t[n][W] = knapSack(valArray, wtArray, W, n - 1);
        else
            return 0;
    }

    public static void main(String[] args) {
        _1MaxProfit_Recursion_Memoization classIs = new _1MaxProfit_Recursion_Memoization();
        classIs.preFill();
        System.out.println("yup: Max 2 profit = " + classIs.knapSack(
                classIs.valArray,
                classIs.wtArray,
                classIs.maxWeight,
                classIs.valArray.length
        ));
    }
}
