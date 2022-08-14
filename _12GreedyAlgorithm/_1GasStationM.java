package _12GreedyAlgorithm;

import java.util.Arrays;

//  https://leetcode.com/problems/gas-station/
//  best explanation: https://www.youtube.com/watch?v=HQpDS9wuzws&ab_channel=AyushiSharma
//  https://www.youtube.com/watch?v=lJwbPZGo05A&ab_channel=NeetCode
public class _1GasStationM {

  public static int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas.length != cost.length) {
      return -1;
    }
    int gasGiven = Arrays.stream(gas).sum();
    int gasNeeded = Arrays.stream(cost).sum();
    //  early check
    if (gasGiven < gasNeeded) {
      return -1;
    }
    int start = 0;
    int curr = 0;
    for (int i = 0; i < gas.length; i++) {
      curr += gas[i] - cost[i];
      if (curr < 0) {
        curr = 0;
        start = i + 1;
      }
    }
    return start;
  }

  public static void main(String[] args) {
    System.out.println("yup: gas station: " + canCompleteCircuit(new int[]{1, 2, 3, 4, 5},
        new int[]{3, 4, 5, 1, 2})); //  3
    System.out.println("yup: gas station: " + canCompleteCircuit(new int[]{2, 3, 4},
        new int[]{3, 4, 3})); //  -1
  }
}
