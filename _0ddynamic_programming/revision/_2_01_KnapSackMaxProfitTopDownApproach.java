package _0ddynamic_programming.revision;

public class _2_01_KnapSackMaxProfitTopDownApproach {

    public static void main(String[] args) {
        int[] valArray = new int[]{1, 4, 5, 7};
        int[] wtArray = new int[]{1, 3, 4, 5};
        int maxWeight = 8; //  max weight a knapsack can hold
        //  yup: maxProfit: 11

//        int[] valArray = new int[]{7, 2, 11, 77};
//        int[] wtArray = new int[]{1, 12, 1, 7};
//        int maxWeight = 6;

        System.out.println("yup: maxProfit: " + knapSack(valArray, wtArray, maxWeight));
    }

    private static int knapSack(int[] valArray, int[] wtArray, int W) {
        if (valArray == null || wtArray == null)
            return 0;

        int[][] t = new int[valArray.length + 1][W + 1];

        for (int n = 0; n < valArray.length + 1; n++) {
            for (int w = 0; w < W + 1; w++) {
                if (n == 0 || w == 0)
                    t[n][w] = 0;

                else if (wtArray[n - 1] <= w) {
                    t[n][w] = Math.max(
                            valArray[n - 1] + t[n - 1][w - wtArray[n - 1]],
                            t[n - 1][w]
                    );
                } else {
                    t[n][w] = t[n - 1][w];
                }
            }
        }
        return t[valArray.length][W];
    }
}
