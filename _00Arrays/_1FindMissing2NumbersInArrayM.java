package _00Arrays;

import java.util.HashMap;
import java.util.Map;

//  this was asked in an interview
public class _1FindMissing2NumbersInArrayM {

  /*
   *
   * sample 1: nums=[1,2] -> answer -> 3,4
   * sample 2: nums=[1,2,5,6] -> answer -> 3,4
   * */

  private static void findMissingTwoNumbersInArray(int[] nums) {
    int n = nums.length + 2;  //  actual size of array
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1); //  num count is not at all considered
    }
    System.out.println("\nyup: missing numbers are: ");
    for (int i = 1; i <= n; i++) {
      if (!map.containsKey(i)) {
        System.out.print(i + " ");
      }
    }
  }

  public static void main(String[] args) {
    findMissingTwoNumbersInArray(new int[]{1, 2});  //  3,4
    findMissingTwoNumbersInArray(new int[]{1, 2, 4, 6});  //  3,5
    findMissingTwoNumbersInArray(new int[]{2, 3, 6});  //  1, 4, 5
  }
}
