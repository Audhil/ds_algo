package _FrazWorkSheet._2Arrays._bitwise;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/missing-number/
//  https://www.youtube.com/watch?v=8ng3R8eeGCA&ab_channel=KeertiPurswani
public class _0SingleMissingNumberInDistinctNumbersE {

  //  using map, suitable for 0,1,2,3, .... n
  private static int singleMissingNumberWithMap(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    for (int i = 0; i < n + 1; i++) {
      map.put(i, 1);
    }
    for (int num : nums) {
      map.remove(num);
    }
    int missingNo = -1;
    for (int key : map.keySet()) {
      missingNo = key;
    }
    return missingNo;
  }

  //  in single loop, suitable for 0,1,2,3, .... n
  private static int singleMissingNumberWithSingleLoop(int[] nums) {
    int res = nums.length;
    for (int i = 0; i < nums.length; i++) {
      res += (i
          - nums[i]); //  counting total, and subtracting nums both at same time, refer missingNumberWithFormula
    }
    return res;
  }

  //  suitable for natural number 1,2,3, .... n. excluding 0
  //  using n(n + 1)/2
  private static int singleMissingNumberWithFormula(int[] nums) {
    int n = nums.length + 1;
    int totSum = (n * (n + 1)) / 2;
    for (int num : nums) {
      totSum -= num;
    }
    return totSum;
  }

  //  a^a = 0
  //  a^0 = a
  //  given array[0,1,3,4] solving as 0^1^2^3^4 ^ 0^1^3^4 = 3
  private static int withXOR(int[] nums) {
    int missingNumber = 0;
    for (int num : nums) {
      missingNumber ^= num; //  XoR with given num
    }
    for (int i = 0; i <= nums.length; i++) {
      missingNumber ^= i; //  XoR with actual numer
    }
    return missingNumber;
  }

  public static void main(String[] args) {
    System.out.println("yup: missingNumberWithMap: " + singleMissingNumberWithMap(
        new int[]{1, 2, 3})); //  yup: missingNumberWithMap: 0
    System.out.println("yup: missingNumberWithMap: " + singleMissingNumberWithMap(
        new int[]{0, 1, 2, 3})); //  yup: missingNumberWithMap: 4
    System.out.println("yup: missingNumberWithFormula: " + singleMissingNumberWithFormula(
        new int[]{1, 2, 3})); //  yup: missingNumberWithFormula: 4
    System.out.println("yup: missingNumberWithFormula: " + singleMissingNumberWithFormula(
        new int[]{1, 2})); //  yup: missingNumberWithFormula: 3
    System.out.println("yup: missingNumberWithSingleLoop: " + singleMissingNumberWithSingleLoop(
        new int[]{1, 2})); //  yup: missingNumberWithSingleLoop: 0
    System.out.println("yup: missingNumberWithSingleLoop: " + singleMissingNumberWithSingleLoop(
        new int[]{1, 2, 3})); //  yup: missingNumberWithSingleLoop: 0
    System.out.println("yup: missingNumberWithSingleLoop: " + singleMissingNumberWithSingleLoop(
        new int[]{0, 1, 2, 3})); //  yup: missingNumberWithSingleLoop: 4
    System.out.println("yup: missingNumberWithSingleLoop: " + singleMissingNumberWithSingleLoop(
        new int[]{0, 1, 2, 4})); //  yup: missingNumberWithSingleLoop: 3
    System.out.println("yup: missingNumberWithFormula: " + singleMissingNumberWithFormula(
        new int[]{1, 2, 4})); //  yup: missingNumberWithFormula: 3
    System.out.println("yup: withXOR: " + withXOR(
        new int[]{0, 1, 3})); //  yup: withXOR: 2
    System.out.println("yup: withXOR: " + withXOR(
        new int[]{0, 1, 2, 4})); //  yup: withXOR: 3
    System.out.println("yup: withXOR: " + withXOR(
        new int[]{1, 2, 3})); //  yup: withXOR: 0
  }
}
