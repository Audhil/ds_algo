package _0dynamic_programming._neetcode.__1dDP;

import java.util.Arrays;
import java.util.List;

//  https://youtu.be/_i4Yxeh5ceQ?t=3035
public class _3HouseRobber_II {

  //  houses are arranged circularly -> house1 and houseN are neighbours to each other
  private static int maxRobWithCircularArrangedHouses(List<Integer> houseList) {
    if (houseList.size() == 1) {
      return houseList.get(0);
    }
    //  skip first(0th index) house and rob others
    int robbedAmt = maxRob(houseList.subList(1, houseList.size()));
    //  skip last house and rob others
    int robbedAmt2 = maxRob(houseList.subList(0, houseList.size() - 1));
    return Math.max(robbedAmt, robbedAmt2);
  }

  //  rob1, rob2, n, n+1, .....
  private static int maxRob(List<Integer> houseList) {
    int rob1 = 0, rob2 = 0;
    for (int amount : houseList) {
      int temp = Math.max(rob1 + amount, rob2);
      rob1 = rob2;
      rob2 = temp;
    }
    return rob2;
  }

  public static void main(String[] args) {
    System.out.println("yup: max rob in circular homes: " + maxRobWithCircularArrangedHouses(
        Arrays.asList(2, 3, 2))); //  yup: max rob in circular homes: 3
    System.out.println("yup: max rob in circular homes: " + maxRobWithCircularArrangedHouses(
        Arrays.asList(1, 2, 3, 1)));  //  yup: max rob in circular homes: 4
    System.out.println("yup: max rob in circular homes: " + maxRobWithCircularArrangedHouses(
        Arrays.asList(1, 2, 3))); //  yup: max rob in circular homes: 3
  }
}
