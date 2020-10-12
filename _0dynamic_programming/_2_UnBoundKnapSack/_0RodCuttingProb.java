package ds_algo._0dynamic_programming._2_UnBoundKnapSack;

//  https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14&ab_channel=AdityaVerma
public class _0RodCuttingProb {
    /*
    * basic difference of Unbounded knapsack
    *
    * else if (wtArray[i - 1] <= j)
                    t[i][j] = Math.max(
                            valArray[i - 1] + t[i][w - wtArray[i - 1]], //  t[i] instead of t[i -1] - this is difference
                            t[n - 1][j] //  I've not chosen the item
                    );
                    //  we won't choose this item
                else if (wtArray[i - 1] > w)
                    t[i][j] = t[i - 1][j];

    * */

//    rod cutting == Unbounded knapsack - keep in mind

    private int[] rodCutLengths = {3, 5, 1, 2};    //  same as wt[], refer _2TopDownApproach.java
    private int[] costs = {9, 15, 3, 6};    //  same as val[], refer _2TopDownApproach.java
    private int rodLength = 6;

    //  find max profit can be done on cutting rod with given lengths
    private int maxProfit() {
        int[][] t = new int[costs.length + 1][rodLength + 1];
        for (int i = 0; i < costs.length + 1; i++) {
            for (int j = 0; j < rodLength + 1; j++) {
                //  initialization
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                    //  choice diagram
                    //  if chosen || not chosen
                else if (rodCutLengths[i - 1] <= j)
                    t[i][j] = Math.max(
                            costs[i - 1] + t[i][j - rodCutLengths[i - 1]], //  on chosen - note: this Unbounded knapsack
                            t[i - 1][j] //  on not chosen
                    );
                    //  definitely not chosen
                else if (rodCutLengths[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[costs.length][rodLength];
    }

    public static void main(String[] args) {
        _0RodCuttingProb prob = new _0RodCuttingProb();
        System.out.println("yup: maxProfit on rod cutting: " + prob.maxProfit());
    }
}

