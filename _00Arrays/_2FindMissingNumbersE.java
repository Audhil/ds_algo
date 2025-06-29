package _00Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

//  https://www.hackerrank.com/challenges/missing-numbers/problem
public class _2FindMissingNumbersE {

  public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (Integer integer : brr) {
      map.put(integer, map.getOrDefault(integer, 0) + 1);
    }
    for (Integer integer : arr) {
      map.put(integer, map.get(integer) - 1);
    }
    List<Integer> result = new ArrayList<>();
    for (Entry<Integer, Integer> set : map.entrySet()) {
      int value = set.getValue();
//      seems unnecessary while loop
//      while (value-- > 0) {
//        result.add(set.getKey());
//      }
      if (value > 0) {
        result.add(set.getKey());
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: missingNumbers: " + missingNumbers(Arrays.asList(7, 2, 5, 3, 5, 3),
            Arrays.asList(7, 2, 5, 4, 6, 3, 5, 3)));  //  yup: missingNumbers: [4, 6]
  }
}
