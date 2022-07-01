package basicToACE._0Greedy;

import java.util.Arrays;

//  https://youtu.be/x86DWJu7zoc?list=PLQXZIFwMtjoz-lIU4qaIHb-gKt46QHdNj&t=438
public class _5MinNoOfCurrencyNotesToMakeSum {

  private static int minNoNotesToMakeSum(int[] noteDenominations, int totSum) {
    if (totSum == 0 || noteDenominations == null) {
      return 0;
    }
    //  sort array
    Arrays.sort(noteDenominations);
    int minNumberOfNotes = 0;
    for (int i = noteDenominations.length - 1; i >= 0; i--) {
      while (totSum >= noteDenominations[i]) {
        totSum -= noteDenominations[i];
        System.out.println("note used: " + noteDenominations[i]);
        minNumberOfNotes++;
      }
      if (totSum <= 0) {
        break;
      }
    }
    return minNumberOfNotes;
  }

  public static void main(String[] args) {
    /*
    * note used: 50
      note used: 20
      note used: 10
      note used: 2
      note used: 1
      yup: minNoNotesToMakeSum: 5
      * */
    System.out.println(
        "yup: minNoNotesToMakeSum: " + minNoNotesToMakeSum(new int[]{50, 1, 20, 5, 10, 2, 100},
            83));
  }
}
