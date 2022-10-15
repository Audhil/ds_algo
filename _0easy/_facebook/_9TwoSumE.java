package _0easy._facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  https://www.lintcode.com/problem/56/?fromId=29&_from=collection
public class _9TwoSumE {

  public static int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int i = 0;
    for (int num : numbers) {
      map.put(num, i++);
    }
    for (i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i])) {
        return new int[]{i, map.get(target - numbers[i])};
      }
    }
    return new int[0];
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: twoSum indices are: " + Arrays.toString(
            twoSum(new int[]{2, 7, 11, 15}, 9))); //  yup: twoSum indices are: [0, 1]
    System.out.println(
        "yup: twoSum indices are: " + Arrays.toString(
            twoSum(new int[]{15, 2, 7, 11}, 9))); //  yup: twoSum indices are: [1, 2]
  }
}
