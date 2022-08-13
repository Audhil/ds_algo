package _10Blind75._6GreedyApproach._jumpGames;

import java.util.LinkedList;
import java.util.Queue;

//  https://leetcode.com/problems/jump-game-iii/
//  https://www.youtube.com/watch?v=7Cz91Uj0VCU&ab_channel=AlgorithmsMadeEasy
public class _03JumpGameIII_M {

  //  tip: solve with BFS - use queue
  //  TC: O (n) & SC: O (n)
  public static boolean canReach(int[] arr, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    while (!queue.isEmpty()) {
      int point = queue.poll();
      //  move left
      if (point - arr[point] >= 0) {
        if (arr[point - arr[point]] == 0) {
          return true;
        } else if (arr[point - arr[point]] > 0) {
          queue.add(point - arr[point]);
        }
      }
      //  move right
      if (point + arr[point] < arr.length) {
        if (arr[point + arr[point]] == 0) {
          return true;
        } else if (arr[point + arr[point]] > 0) {
          queue.add(point + arr[point]);
        }
      }
      arr[point] = -1;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: canReach the destination with value 0: " + canReach(new int[]{4, 2, 3, 0, 3, 1, 2},
            5));  //  true
    System.out.println(
        "yup: canReach the destination with value 0: " + canReach(new int[]{4, 2, 3, 0, 3, 1, 2},
            0));  //  true
    System.out.println(
        "yup: canReach the destination with value 0: " + canReach(new int[]{3, 0, 2, 1, 2},
            2));  //  false
  }
}
