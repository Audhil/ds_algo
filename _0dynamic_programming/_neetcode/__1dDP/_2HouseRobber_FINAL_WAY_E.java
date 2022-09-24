package _0dynamic_programming._neetcode.__1dDP;

//  https://youtu.be/_i4Yxeh5ceQ?t=2308

import java.util.Arrays;
import java.util.List;

//  _4HouseRobberM.java also has good explanation with recursion and iterative approaches
public class _2HouseRobber_FINAL_WAY_E {

  //  TC: O (n)
  //  iterating from L to R
  private static int maxRob(List<Integer> houseList) {
    int rob1 = 0, rob2 = 0;
    //  list will rob1, rob2, n, n+1, n+2, ....
    for (int amount : houseList) {
      int temp = Math.max(rob1 + amount, rob2);
      rob1 = rob2;
      rob2 = temp;
    }
    return rob2;  //  when we reach end, rob2 will have maxRob till now
  }

  public static void main(String[] args) {
    System.out.println("yup: maxRob between houses: " + maxRob(
        Arrays.asList(1, 2, 3, 1))); //  yup: maxRob between houses: 4 -> rob house1 & house3
  }
}
