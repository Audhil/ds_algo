package _10Blind75._6GreedyApproach._jumpGames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//  https://leetcode.com/problems/jump-game-iv/
//  https://www.youtube.com/watch?v=XgP3w7Txvlc&ab_channel=AyushiSharma
public class _04JumpGameIV_H {

  //  Tips: Do the BFS
  public static int minJumps(int[] arr) {
    int n = arr.length;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<Integer> list;
      if (map.containsKey(arr[i])) {
        list = map.get(arr[i]);
      } else {
        list = new ArrayList<>();
      }
      list.add(i);
      map.put(arr[i], list);
    }
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n];
    queue.add(0);   //  add the indices
    visited[0] = true;
    int steps = 0;
    while (!queue.isEmpty()) {
      for (int size = queue.size(); size > 0; size--) {
        int point = queue.poll();
        if (point == n - 1) {
          return steps;
        }
        //  other indices where this item present
        List<Integer> list = map.get(arr[point]);
        //  i - 1;
        if (point - 1 >= 0) {
          list.add(point - 1);
        }
        //  i + 1;
        if (point + 1 < n) {
          list.add(point + 1);
        }
        for (int index : list) {
          if (!visited[index]) {
            queue.add(index);
            visited[index] = true;
          }
        }
        map.get(arr[point]).clear();  //  clear the map
      }
      steps++;
    }
    return steps;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: minJumps: " + minJumps(
            new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));  //  3

    System.out.println(
        "yup: minJumps: " + minJumps(new int[]{7}));  //  0

    System.out.println(
        "yup: minJumps: " + minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7})); //  1
  }
}
