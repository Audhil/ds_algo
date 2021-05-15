package ds_algo._0dynamic_programming._1_01KnapSack;

//  THIS IS 0 1 knapSack problem
//  the best explanation!!!!!
//  using recursion: https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3&ab_channel=AdityaVerma
public class _0MaxProfit_with_Recursion {

    private int[] valArray = new int[]{7, 2, 11, 77};
    private int[] wtArray = new int[]{1, 12, 1, 7};
    private int maxWeight = 6; //  max weight a knapsack can hold

    private int knapSack(int[] valArray, int[] wtArray, int W, int n) {
        //  base condition
        if (W == 0 || n == 0)
            return 0;

        //  choice diagram
        //  we'll iterate from last index
        if (wtArray[n - 1] <= W)
            return Math.max(
                    valArray[n - 1] + knapSack(valArray, wtArray, W - wtArray[n - 1], n - 1),   //  on taking the item
                    knapSack(valArray, wtArray, W, n - 1)   //  on not taking the item
            );
            //  the other side
        else if (wtArray[n - 1] > W)
            return knapSack(valArray, wtArray, W, n - 1);   //  on not taking the item - we won't take the item
        else
            return 0;
    }

    public static void main(String[] args) {
        _0MaxProfit_with_Recursion topClass = new _0MaxProfit_with_Recursion();
        System.out.println("yUP max profit: " + topClass.knapSack(
                topClass.valArray, topClass.wtArray, topClass.maxWeight, topClass.valArray.length
        ));
    }
}
