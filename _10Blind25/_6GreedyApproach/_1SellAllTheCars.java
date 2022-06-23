package _10Blind25._6GreedyApproach;

import java.util.Arrays;

//  https://www.codechef.com/submit/CARSELL
//  refer: https://youtu.be/tw_cqPzpCKM?list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&t=3559
public class _1SellAllTheCars {

  private static int solution(int[] carRates) {
    int noOfCars = carRates.length;
    //  sort car rates
    Arrays.sort(carRates);
    //  reverse to make it descending
    reverse(carRates);
    int maxProfit = 0;
    //  start selling, the costliest cars first and then cheaper
    for (int i = 0; i < noOfCars; i++) {
      maxProfit += Math.max(0, carRates[i] - i);  //  rate of the car - depreciation per year.
      // we are preventing this value becoming -ve(once car rate 0, next year after depreciation,
      // car rate doesn't changes to -ve)
    }
    return maxProfit;
  }

  private static void reverse(int[] array) {
    int i = 0, j = array.length - 1;
    while (i < j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i++;
      j--;
    }
  }

  public static void main(String[] args) {
    System.out.println("yup: car rates 44, 1, 9, 4, 99, 12, 69: maxProfit: " + solution(
        new int[]{44, 1, 9, 4, 99, 12, 69}));
    System.out.println("yup: car rates 6,6,6: maxProfit: " + solution(new int[]{6, 6, 6}));
    System.out.println("yup: car rates 0,1,0: maxProfit: " + solution(new int[]{0, 1, 0}));
  }
}
