package ds_algo._0dynamic_programming._2_UnBoundKnapSack;

//  https://youtu.be/I-l6PBeERuc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _2CoinChange_MinNoOfCoins {
    /*
    *
    * Coin Change Problem Minimum Numbers of coins
        Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
        Example:

        Input: coins[] = {25, 10, 5}, V = 30
        Output: Minimum 2 coins required
        We can use one coin of 25 cents and one of 5 cents
    * */

    //  find min no of coins required to achieve the given sum

//    private int[] coins = {1, 2, 3};
//    private int sum = 5;

//    private int[] coins = {9, 6, 5, 1};
//    private int sum = 11;

//    private int[] coins = {9, 6, 3, 1};
//    private int sum = 4;

    private int[] coins = {2, 4};
    private int sum = 7;

    private int minNoOfCoinsRequired() {
        int[][] t = new int[coins.length + 1][sum + 1];

        //  initialization - 1
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0)
                    t[i][j] = Integer.MAX_VALUE - 1;    //  infinite coins required to make sum 0, when arr[] is 0
                else if (i == 0)
                    t[i][j] = Integer.MAX_VALUE - 1;    //  infinite coins required to make sum 0, when arr[] is 0
                else if (j == 0)
                    t[i][j] = 0;    //  no coins required to make sum 0
            }
        }

        //  https://youtu.be/I-l6PBeERuc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&t=1136
        //  initialization - 2 - initializing 2nd row
        if (coins.length > 1)   //  safer check - if there's only one coin available?
            for (int j = 1; j < sum + 1; j++) {
                //  if sum is fully divisible by coin, put 1
                if (j % coins[0] == 0)
                    t[1][j] = j / coins[0];
                    //  if sum is not fully divisible by coin, put infinite
                else if (j % coins[0] != 0)
                    t[1][j] = Integer.MAX_VALUE - 1;
            }

        //  choice diagram
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                //  may/not choose the coin
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(
                            t[i][j - coins[i - 1]] + 1,  //  coin is chosen, +1 for counting
                            t[i - 1][j] //  coin not chosen
                    );
                }
                //  we'll not choose coin
                else if (coins[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[coins.length][sum];
    }

    public static void main(String[] args) {
        _2CoinChange_MinNoOfCoins prob = new _2CoinChange_MinNoOfCoins();
        if (prob.minNoOfCoinsRequired() == Integer.MAX_VALUE - 1)
            System.out.println("yup: min coin: NOT POSSIBLE");
        else
            System.out.println("yup: min coin: " + prob.minNoOfCoinsRequired());
    }
}
