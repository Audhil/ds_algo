package _0ddynamic_programming.revision;

public class _0_01_KnapSackMaxProfit {

  public static void main(String[] args) {
    int[] valArray = new int[]{1, 4, 5, 7};
    int[] wtArray = new int[]{1, 3, 4, 5};
    int maxWeight = 7; //  max weight a knapsack can hold

    System.out.println("maxProfit: " + knapSack(wtArray, valArray, maxWeight, wtArray.length));
  }

  private static int knapSack(int[] wtArray, int[] valArray, int W, int n) {
      if (n == 0 || W == 0) {
          return 0;
      }

    //  max profit
      if (wtArray[n - 1] <= W) {
          return Math.max(
              valArray[n - 1] + knapSack(wtArray, valArray, W - wtArray[n - 1], n - 1),
              //  we are taking the weight
              knapSack(wtArray, valArray, W, n - 1)   //  we are not taking the weight
          );
      } else {
          return knapSack(wtArray, valArray, W, n - 1);   //  we can't take the weight
      }
  }
}
