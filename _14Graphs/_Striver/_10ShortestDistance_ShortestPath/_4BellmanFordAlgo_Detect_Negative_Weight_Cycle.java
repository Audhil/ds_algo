package _14Graphs._Striver._10ShortestDistance_ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=75yC1vbS8S8&ab_channel=takeUforward
public class _4BellmanFordAlgo_Detect_Negative_Weight_Cycle {

  //  tip: Dijikstra's algo not suitable to find the shortest path, when there's neg weight
  //  we need BellmanFord's algo for that
  //  formula: dist[u] + weight < dist[v] for (N - 1) iteration

  //  TC: O (N - 1) * O (E) -> very bad compared to Dijikstra's algo
  //  SC: O (N)
  private static class Node {

    int startVertex, endVertex, weight;

    public Node(int startVertex, int endVertex, int weight) {
      this.startVertex = startVertex;
      this.endVertex = endVertex;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "Node{" +
          "startVertex=" + startVertex +
          ", endVertex=" + endVertex +
          ", weight=" + weight +
          '}';
    }
  }

  private static boolean isCycleAvailableInNegWeightGraph(List<Node> adjList, int N, int src) {
    int[] distArr = new int[N];
    for (int i = 0; i < N; i++) {
      distArr[i] = Integer.MAX_VALUE;
    }
    distArr[src] = 0;
    //  N - 1 iterations
    for (int i = 0; i <= N - 1; i++) {
      for (Node edge : adjList) {
        int calcDist = distArr[edge.startVertex] + edge.weight;
        if (distArr[edge.startVertex] != Integer.MAX_VALUE && calcDist < distArr[edge.endVertex]) {
          distArr[edge.endVertex] = calcDist;
        }
      }
    }
    boolean isCyclePresent = false;
    for (Node edge : adjList) {
      int calcDist = distArr[edge.startVertex] + edge.weight;
      if (distArr[edge.startVertex] != Integer.MAX_VALUE && calcDist < distArr[edge.endVertex]) {
        isCyclePresent = true;
        System.out.println("yup: negative cycle present...");
        return isCyclePresent;
      }
    }

    //  min distance from the src is as follows
    System.out.println("yup: min distance from : " + src + ", is : " + Arrays.toString(distArr));
    return isCyclePresent;
  }

  public static void main(String[] args) {
    int N = 6;
    List<Node> adjList = new ArrayList<>();
    adjList.add(new Node(3, 2, 6));
    adjList.add(new Node(5, 3, 1));
    adjList.add(new Node(0, 1, 5));
    adjList.add(new Node(1, 5, -3));
    adjList.add(new Node(1, 2, -2));
    adjList.add(new Node(3, 4, -2));
    adjList.add(new Node(2, 4, 3));
    System.out.println(
        "yup: isCycleAvailableInNegWeightGraph() : " + isCycleAvailableInNegWeightGraph(adjList, N,
            0));
    //  yup: min distance from : 0, is : [0, 5, 3, 3, 1, 2]
    //  yup: isCycleAvailableInNegWeightGraph() : false
  }
}
