package _10Blind25._6GreedyApproach._6TopQuestions;

//  https://youtu.be/lZJGbS12mWo?list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&t=2867
//  https://www.codechef.com/problems/CIELRCPT
public class _1CielAndReceipt {

  private static int minItemsToSelect(int p) {
    int[] menu = {2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    int noOfItemsPicked = 0;
    while (p > 0) {
      for (int foodCost : menu) {
        if (foodCost <= p) {
          noOfItemsPicked++;
          p -= foodCost;
          break;
        }
      }
    }
    return noOfItemsPicked;
  }

  public static void main(String[] args) {
    System.out.println("yup: minItemsToSelect: 10: " + minItemsToSelect(10));
    System.out.println("yup: minItemsToSelect: 256: " + minItemsToSelect(256));
    System.out.println("yup: minItemsToSelect: 255: " + minItemsToSelect(255));
    System.out.println("yup: minItemsToSelect: 4096: " + minItemsToSelect(4096));
  }
}
