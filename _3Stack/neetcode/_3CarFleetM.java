package _3Stack.neetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//  https://leetcode.com/problems/car-fleet/description/
public class _3CarFleetM {

  //  TC: O (n log n)
  public static int carFleet(int target, int[] position, int[] speed) {
    int[][] combine = new int[position.length][2];
    for (int i = 0; i < position.length; i++) {
      combine[i][0] = position[i];
      combine[i][1] = speed[i];
    }
    Arrays.sort(combine, Comparator.comparingInt(o -> o[0])); //  sort based on position
    Stack<Double> stack = new Stack<>();
    for (int i = position.length - 1; i >= 0; i--) {
      double currTime =
          (double) (target - combine[i][0]) / combine[i][1];  //  (target - pos) / speed
      //  don't push fastest cars into stack
      if (!stack.isEmpty() && currTime <= stack.peek()) {
        continue;
      }
      stack.push(currTime);
    }
    return stack.size();
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: carFleet: " + carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3})); //  3
    System.out.println(
        "yup: carFleet: " + carFleet(10, new int[]{3}, new int[]{3}));  //  1
    System.out.println(
        "yup: carFleet: " + carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1})); //  1
  }
}
