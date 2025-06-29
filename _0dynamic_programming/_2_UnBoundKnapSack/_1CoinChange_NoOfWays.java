package ds_algo._0dynamic_programming._2_UnBoundKnapSack;

//  https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15&ab_channel=AdityaVerma
public class _1CoinChange_NoOfWays {

    private int[] coins = {1, 2, 3};    //  we can use unlimited no of coins, any coin can be used more than 1 time
    private int sum = 5;

    //  find noOfWays to make sum, by choosing the coins

    private int noOfWaysToMakeSumIs() {
        int[][] t = new int[coins.length + 1][sum + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                //  initialization
                if (i == 0 && j == 0)
                    t[i][j] = 1;
                else if (i == 0)
                    t[i][j] = 0;
                else if (j == 0)
                    t[i][j] = 1;
                    //  choice diagram
                else if (coins[i - 1] <= j)
                    t[i][j] = t[i][j - coins[i - 1]]    //  on choosing the coin
                            +
                            t[i - 1][j];    //  on not choosing the coin
                    //  we won't choose the coin
                else if (coins[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[coins.length][sum];
    }

    public static void main(String[] args) {
        _1CoinChange_NoOfWays prob = new _1CoinChange_NoOfWays();
        System.out.println("yup: noOfWays: " + prob.noOfWaysToMakeSumIs());
    }
}
