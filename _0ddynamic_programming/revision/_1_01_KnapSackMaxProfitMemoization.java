package _0ddynamic_programming.revision;

public class _1_01_KnapSackMaxProfitMemoization {

    public static void main(String[] args) {
        int[] valArray = new int[]{1, 4, 5, 7};
        int[] wtArray = new int[]{1, 3, 4, 5};
        int maxWeight = 7; //  max weight a knapsack can hold


        int n = wtArray.length;
        int W = maxWeight;
        int[][] t = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println("maxProfit: " + knapSack(wtArray, valArray, W, n, t));
    }

    private static int knapSack(int[] wtArray, int[] valArray, int W, int n, int[][] t) {
        if (n == 0 || W == 0)
            return 0;

        if (t[n][W] != -1)
            return t[n][W];

        //  max profit
        if (wtArray[n - 1] <= W)
            return t[n][W] = Math.max(
                    valArray[n - 1] + knapSack(wtArray, valArray, W - wtArray[n - 1], n - 1, t),  //  we are taking the weight
                    knapSack(wtArray, valArray, W, n - 1, t)   //  we are not taking the weight
            );
        else
            return t[n][W] = knapSack(wtArray, valArray, W, n - 1, t);   //  we can't take the weight
    }
}
