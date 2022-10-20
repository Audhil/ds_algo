package _00Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
public class _17FindAllLonelyNumsInArr_M {

  public static List<Integer> findLonely(int[] nums) {
    Map<Integer, Integer> cMap = new HashMap<>();
    for (int num : nums) {
      cMap.put(num, cMap.getOrDefault(num, 0) + 1);
    }
    List<Integer> ansList = new ArrayList<>();
    for (int num : nums) {
      if (cMap.get(num) == 1 && !cMap.containsKey(num + 1) && !cMap.containsKey(num - 1)) {
        ansList.add(num);
      }
    }
    return ansList;
  }

  public static void main(String[] args) {
    System.out.println("yup: lonely nums: " + findLonely(new int[]{10, 6, 5, 8}));  //  yup: lonely nums: [10, 8]
    System.out.println("yup: lonely nums: " + findLonely(new int[]{1, 3, 5, 3})); //  yup: lonely nums: [1, 5]
  }
}
