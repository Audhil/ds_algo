package _00Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://www.hackerrank.com/challenges/minimum-loss/problem
//  https://www.youtube.com/watch?v=X6DqnrpjEWA&ab_channel=NikhilLohia
public class _5MinimumLossHackerRankM {

  //  https://youtu.be/WJhToXHJvb4
  //  TC: n log n
  public static int minimumLoss(List<Long> price) {
    Map<Long, Integer> iMap = new HashMap<>();
    int n = price.size();
    for (int i = 0; i < n; i++) {
      iMap.put(price.get(i), i);
    }
    Collections.sort(price);
    int minLoss = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      //  comparing indices
      if (iMap.get(price.get(i - 1)) > iMap.get(price.get(i))) {
        minLoss = Math.min(minLoss,
            (int) (price.get(i) - price.get(i - 1))); //  for +ve vals, since it is sorted
      }
    }
    return minLoss;
  }

  //  TC: O (n log n)
//  public static int minimumLoss(List<Long> price) {
//    Map<Long, Integer> map = new HashMap<>();
//    for (int i = 0; i < price.size(); i++) {
//      map.put(price.get(i), i);
//    }
//    Collections.sort(price);
//    long minLoss = Long.MAX_VALUE;
//    for (int i = price.size() - 1; i > 0; i--) {
//      long priceCurr = price.get(i);
//      long pricePrev = price.get(i - 1);
//      //  comparing indices
//      if (map.get(priceCurr) < map.get(pricePrev)) {
//        minLoss = Math.min(minLoss, priceCurr - pricePrev);
//      }
//    }
//    return (int) minLoss;
//  }

  public static void main(String[] args) {
    System.out.println(
        "yup: min loss of selling house: " + minimumLoss(
            Arrays.asList(20L, 15L, 8L, 2L, 12L)));  //  yup: min loss of selling house: 3
    System.out.println(
        "yup: min loss of selling house: " + minimumLoss(
            Arrays.asList(5L, 10L, 3L)));  //  yup: min loss of selling house: 2
    System.out.println(
        "yup: min loss of selling house: " + minimumLoss(
            Arrays.asList(20L, 7L, 8L, 2L, 5L)));  //  yup: min loss of selling house: 2
  }
}
