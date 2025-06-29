package _14Graphs._Striver._10ShortestDistance_ShortestPath._3DijikstrasAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//  https://www.youtube.com/watch?v=vWgoPTvQ3Rw&ab_channel=ShiranAfergan - best explanation
//  https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class _7CheapestFlightsWithKstops_DijikstrasAlgo {

  //  flights - [from, to, cost]
  private static int dijkStra(List<List<int[]>> adjList, int src, int dst, int k, int n) {
    Queue<int[]> minHeap = new PriorityQueue<>(
        (a, b) -> a[1] - b[1]);  //  minHeap based on distance
    int[] distArr = new int[n];
    Arrays.fill(distArr, Integer.MAX_VALUE);
    int[] stopsArr = new int[n];
    Arrays.fill(stopsArr, Integer.MAX_VALUE);
    distArr[src] = 0;
    stopsArr[src] = 0;
    //  node, dist, stop
    minHeap.add(new int[]{src, 0, 0});
    while (!minHeap.isEmpty()) {
      int[] curr = minHeap.poll();
      if (curr[0] == dst) {
        return curr[1];
      }
      //  including destination node, hence k +1;
      if (curr[2] == k + 1) {
        continue;
      }
      for (int[] edge : adjList.get(curr[0])) {
        int nextDist = curr[1] + edge[1];
        int nextStop = curr[2] + 1;
        if (nextDist < distArr[edge[0]] || nextStop < stopsArr[edge[0]]) {
          distArr[edge[0]] = nextDist;
          stopsArr[edge[0]] = nextStop;
          minHeap.add(new int[]{edge[0], nextDist, nextStop});
        }
      }
    }
    return -1;
  }

  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //  1. adjList
    List<List<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] flight : flights) {
      adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
    }
    return dijkStra(adjList, src, dst, k, n);
  }

  public static void main(String[] args) {
    System.out.println("yup: cheapest flight: " + findCheapestPrice(4, new int[][]{
        {0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}
    }, 0, 3, 1)); //  700

    System.out.println("yup: cheapest flight: " + findCheapestPrice(3, new int[][]{
        {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
    }, 0, 2, 1)); //  200

    System.out.println("yup: cheapest flight: " + findCheapestPrice(3, new int[][]{
        {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
    }, 0, 2, 0)); //  500
  }
}
