package _14Graphs._Striver._10ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  https://www.youtube.com/watch?v=hwCWi7-bRfI&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=17&ab_channel=takeUforward
public class _1ShortestDistanceInUndirectedGraph {

  //  TC: O (N + E)
  //  SC: O (N) + O (N) -> queue size + dist arr
  private static void shortestPath(List<List<Integer>> adjList, int N, int src) {
    if (adjList == null || adjList.isEmpty()) {
      return;
    }
    int[] distArr = new int[N];
    for (int i = 0; i < N; i++) {
      distArr[i] = Integer.MAX_VALUE;
    }
    distArr[src] = 0; //  distance to reach src
    Queue<Integer> queue = new LinkedList<>();
    queue.add(src);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int nei : adjList.get(node)) {
        //  +1 assuming weight of edge is 1
        if (distArr[node] + 1 < distArr[nei]) {
          distArr[nei] = distArr[node] + 1;
          queue.add(nei);
        }
      }
    }

    System.out.println(
        "yup: distance Arr from src " + src + ", to other nodes: " + Arrays.toString(distArr));
  }

  public static void main(String[] args) {
    List<List<Integer>> adjList = new ArrayList<>();
    adjList.add(Arrays.asList(1, 3));
    adjList.add(Arrays.asList(0, 2, 3));
    adjList.add(Arrays.asList(1, 6));
    adjList.add(Arrays.asList(0, 4));
    adjList.add(Arrays.asList(3, 5));
    adjList.add(Arrays.asList(4, 6));
    adjList.add(Arrays.asList(2, 5, 7, 8));
    adjList.add(Arrays.asList(6, 8));
    adjList.add(Arrays.asList(6, 7));
    shortestPath(adjList, 9,
        0);  //  yup: distance Arr from src 0, to other nodes: [0, 1, 2, 1, 2, 3, 3, 4, 4]
  }
}
