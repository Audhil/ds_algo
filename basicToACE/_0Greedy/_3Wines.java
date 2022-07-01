package basicToACE._0Greedy;

import java.util.Arrays;

//  https://youtu.be/qdFUpU7sdRs?t=6465
public class _3Wines {

  private static int maxProfitWithWines(int[] wineRates) {
    if (wineRates == null) {
      return 0;
    }

    Arrays.sort(wineRates);
    int maxProfit = 0;
    //  sell the less rate wines in each year
    for (int i = 0; i < wineRates.length; i++) {
      maxProfit += ((i + 1) * wineRates[i]);
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println("maxProfit: " + maxProfitWithWines(new int[]{55, 2, 20, 5, 99, 1})); //  969
    System.out.println("maxProfit: " + maxProfitWithWines(new int[]{3, 2, 1})); //  14
  }
}
