package _FrazWorkSheet._2Arrays._bitwise;

import java.util.Arrays;

//  in reference to : _0SingleMissingNumberInDistinctNumbersE.java
public class _1_2MissingNumbersInDistinctNumbersE {

  //  considering nums are 1,2,3, .... n, excluding 0
  //  https://youtu.be/8ng3R8eeGCA?t=332
  //  integer overflow will happen for bigger number
  private int[] find2MissingNumbers(int[] nums) {
    int n = nums.length;
    //  find total sum
    int totSum = n * (n + 1) / 2;
    //  missing nums x, y
    int arraySum = 0;
    for (int num : nums) {
      arraySum += num;
    }
    int missingNumsTotal = totSum - arraySum;
    int avgOfTotal =
        missingNumsTotal / 2;  //  let us assume, x as smaller than avg, y as bigger than avg
    int maxNumBelowAvg = avgOfTotal - 1;
    int totSumBelowAvg = maxNumBelowAvg * (maxNumBelowAvg + 1) / 2;
    int arraySumBelowAvg = 0;
    //  i'm not interested in writing this code more than these line, watch video for explanation
    return null;
  }

  //  https://youtu.be/8ng3R8eeGCA?t=787
  //  with XOR, find x, y
  private static int[] find2MissingNumbersWithXOR(int[] nums) {
    int xorOfMissingNumbers = 0;  //  will hold : x + y
    int maxNum = Integer.MIN_VALUE;
    for (int num : nums) {
      xorOfMissingNumbers ^= num;
      maxNum = Math.max(maxNum, num);
    }
    for (int i = 1; i <= maxNum; i++) {
      xorOfMissingNumbers ^= i;
    }
    System.out.println(xorOfMissingNumbers);
    int x = 0, y = 0;
    for (int i = 0; i <= 31; i++) {
      int bit = xorOfMissingNumbers & (1 << i);
      if (bit == 1) {
        for (int j = 1; j <= maxNum; j++) {
          int extractedBit = j & (1 << i);
          if(extractedBit == 1){
            //  I'm not interested in coding more
          }
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: find2MissingNumbersWithXOR: " + Arrays.toString(
            find2MissingNumbersWithXOR(new int[]{1, 2, 4, 6})));
  }
}
