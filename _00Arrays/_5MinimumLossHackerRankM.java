package _00Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://www.hackerrank.com/challenges/minimum-loss/problem
//  https://www.youtube.com/watch?v=X6DqnrpjEWA&ab_channel=NikhilLohia
public class _5MinimumLossHackerRankM {

  //  TC: O (n log n)
  public static int minimumLoss(List<Long> price) {
    Map<Long, Integer> map = new HashMap<>();
    for (int i = 0; i < price.size(); i++) {
      map.put(price.get(i), i);
    }
    Collections.sort(price);
    long minLoss = Long.MAX_VALUE;
    for (int i = price.size() - 1; i > 0; i--) {
      Long priceIndex = price.get(i);
      Long prevPriceIndex = price.get(i - 1);
      if (map.get(priceIndex) < map.get(prevPriceIndex)) {
        minLoss = Math.min(minLoss, price.get(i) - price.get(i - 1));
      }
    }
    return (int) minLoss;
  }

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
