package _14Graphs._Striver._10ShortestDistance_ShortestPath._3DijikstrasAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//  https://leetcode.com/problems/network-delay-time/
//  https://www.youtube.com/watch?v=EaphyqKU4PQ&t=14s&ab_channel=NeetCode
public class _4NetworkDelayTime_DijikstrasAlgo {

  //  TC: O (N + E) * log N ~ N log N
  //  SC: O (N)
  private static class Pair {

    int time, vertex;

    public Pair(int weight, int vertex) {
      this.time = weight;
      this.vertex = vertex;
    }
  }

  //  times - u,v,w
  public static int networkDelayTime(int[][] times, int n, int k) {
    //  1. build adjacency list
    Map<Integer, List<Pair>> adjMap = new HashMap<>();
    for (int[] t : times) {
      adjMap.putIfAbsent(t[0], new ArrayList<>());
      adjMap.get(t[0]).add(new Pair(t[2], t[1]));
    }
    //  2. distArr - node starts from 1st index
    int[] distArr = new int[n + 1];
    Arrays.fill(distArr, Integer.MAX_VALUE);  //  add infinity to each item
    dijkstra(distArr, adjMap, k);
    int result = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      result = Math.max(result, distArr[i]);
    }
    return result == Integer.MAX_VALUE
        ? -1 : result; //  // INT_MAX signifies atleat one node is unreachable
  }

  private static void dijkstra(int[] distArr, Map<Integer, List<Pair>> adjMap, int k) {
    Queue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.time - b.time);
    minHeap.add(new Pair(0, k));
    distArr[k] = 0;
    while (!minHeap.isEmpty()) {
      Pair currNode = minHeap.poll();
      if (!adjMap.containsKey(currNode.vertex)) {
        continue;
      }
      for (Pair nbrNode : adjMap.get(currNode.vertex)) {
        int calcDist = currNode.time + nbrNode.time;
        if (calcDist < distArr[nbrNode.vertex]) {
          distArr[nbrNode.vertex] = calcDist;
          minHeap.add(new Pair(calcDist, nbrNode.vertex));
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: Network Delay: " + networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4,
            2));  //  2

    System.out.println(
        "yup: Network Delay: " + networkDelayTime(new int[][]{{1, 2, 1}}, 2,
            1));  //  1

    System.out.println(
        "yup: Network Delay: " + networkDelayTime(new int[][]{{1, 2, 1}}, 2,
            2));  //  -1
  }
}
