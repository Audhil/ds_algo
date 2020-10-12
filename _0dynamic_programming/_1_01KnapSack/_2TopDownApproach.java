package ds_algo._0dynamic_programming._1_01KnapSack;

//  THIS IS 0 1 knapSack problem
//  https://youtu.be/ntCGbPMeqgg?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _2TopDownApproach {

    //  iterative approach
    //  I've re-used recursive function(ds_algo._0dynamic_programming._1_01KnapSack._1MaxProfit_Recursion_Memoization) or (ds_algo._0dynamic_programming._1_01KnapSack._0MaxProfit_with_Recursion) to write this iterative approach

    private int[] valArray = new int[]{7, 2, 11, 77};
    private int[] wtArray = new int[]{1, 12, 1, 7};
    private int maxWeight = 6; //  max weight a knapsack can hold - we are not using it here - it became max profit can be calculated when 2D array is constructed

    private int knapSack_MaxProfit() {
        int[][] t = new int[valArray.length + 1][wtArray.length + 1];

        for (int n = 0; n < valArray.length + 1; n++) {
            for (int w = 0; w < wtArray.length + 1; w++) {
                //  initialization - base condition
                if (n == 0 || w == 0)
                    t[n][w] = 0;

                    //  choice diagram
                    //  we'll choose or not choose this item
                else if (wtArray[n - 1] <= w)
                    t[n][w] = Math.max(
                            valArray[n - 1] + t[n - 1][w - wtArray[n - 1]], //  I've chosen the item, and hence reduce chosen weight from tot weight
                            t[n - 1][w] //  I've not chosen the item
                    );
                    //  we won't choose this item
                else if (wtArray[n - 1] > w)
                    t[n][w] = t[n - 1][w];  //  we can't choose the item, since weight is more than knapSacks weight capacity
            }
        }

        for (int i = 0; i < valArray.length + 1; i++) {
            for (int j = 0; j < wtArray.length + 1; j++) {
                System.out.print(" " + t[i][j] + " ");
            }
            System.out.println();
        }

        return t[valArray.length][wtArray.length];  //  max profit will be available at last index
    }

    //  create 2d array
    public static void main(String[] args) {
        _2TopDownApproach approach = new _2TopDownApproach();
        System.out.println("yup: 3 maxProfit: " + approach.knapSack_MaxProfit());
    }
}
