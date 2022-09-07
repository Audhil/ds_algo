package _14Graphs._Striver._10ShortestDistance_ShortestPath._3DijikstrasAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//  https://www.youtube.com/watch?v=jbhuqIASjoM&ab_channel=takeUforward
public class _3DijikstrasAlgo_Undirected_weighted_Graph {

  //  TC: O (N + E) * log N ~ N log N
  //  SC: O (N)
  private static class Node {

    int vertex;
    int edgeDistance;

    public Node(int vertex, int edgeDistance) {
      this.vertex = vertex;
      this.edgeDistance = edgeDistance;
    }
  }

  private static int[] findShortestDistanceUsingDijikstraAlgo(
      List<List<Node>> adjList,
      int N,
      int src) {
    int[] distArr = new int[N];
    //  adding infinity to all items
    for (int i = 0; i < N; i++) {
      distArr[i] = Integer.MAX_VALUE;
    }
    distArr[src] = 0;
    //  1. minHeap
    PriorityQueue<Node> minHeapQueue =
        new PriorityQueue<>((a, b) -> b.edgeDistance - a.edgeDistance);
    minHeapQueue.add(new Node(src, 0));
    //  2. iterate queue
    while (!minHeapQueue.isEmpty()) {
      Node temp = minHeapQueue.poll();
      for (Node nbr : adjList.get(temp.vertex)) {
        int calcDistance = nbr.edgeDistance + temp.edgeDistance;
        if (calcDistance < distArr[nbr.vertex]) {
          distArr[nbr.vertex] = calcDistance;
          minHeapQueue.add(new Node(nbr.vertex, calcDistance));
        }
      }
    }
    return distArr;
  }

  public static void main(String[] args) {
    int N = 6;
    List<List<Node>> adjList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adjList.add(new ArrayList<>());
    }

    adjList.get(1).add(new Node(2, 2));
    adjList.get(2).add(new Node(1, 2));

    adjList.get(1).add(new Node(4, 1));
    adjList.get(4).add(new Node(1, 1));

    adjList.get(2).add(new Node(5, 5));
    adjList.get(5).add(new Node(2, 5));

    adjList.get(2).add(new Node(3, 4));
    adjList.get(3).add(new Node(2, 4));

    adjList.get(4).add(new Node(3, 3));
    adjList.get(3).add(new Node(4, 3));

    adjList.get(3).add(new Node(5, 1));
    adjList.get(5).add(new Node(3, 1));

    int src = 1;
    System.out.println(
        "yup: shortest distance from node: " + src + " to all other nodes: " + Arrays.toString(
            findShortestDistanceUsingDijikstraAlgo(adjList, N,
                src)));  //  yup: shortest distance from node: 1 to all other nodes: [2147483647, 0, 2, 4, 1, 5]
  }
}
