package _14Graphs._Striver._10ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//  https://www.youtube.com/watch?v=CrxG4WJotgg&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=19&ab_channel=takeUforward
public class _2ShortestDistanceInDirectedGraph_weighted_DAG {

  //  steps:
  //  1. find topological sort - with either DFS or BFS
  //  2. pop items from stack and find shortest path
  private static class Node {

    int vertex;
    int weigth;

    public Node(int vertex, int weigth) {
      this.vertex = vertex;
      this.weigth = weigth;
    }

    @Override
    public String toString() {
      return "Node{" +
          "vertex=" + vertex +
          ", weigth=" + weigth +
          '}';
    }
  }

  //  TC: O (V + E) + O (V + E) = topological sort with DFS + distance measurement with BFS
  //  SC: O (N) + O (N) + {O (N)} = stack space + distance array space + optional {auxiliary stack space if it DFS, we can avoid this in BFS}

  private static void shortestPath(List<List<Node>> adjList, int N, int src) {
    //  1. find topological sort
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[N];
    for (int vertex = 0; vertex < N; vertex++) {
      if (!visited[vertex]) {
        dfsHelper(vertex, visited, adjList, stack);
      }
    }
    //  2. find shortest path
    int[] distArr = new int[N];
    for (int i = 0; i < N; i++) {
      distArr[i] = Integer.MAX_VALUE; //  add infinity
    }
    distArr[src] = 0;
    while (!stack.isEmpty()) {
      int temp = stack.pop();
      if (distArr[temp]
          != Integer.MAX_VALUE) { //  do the following, if it is calculated - I think this is not required.
        for (Node nei : adjList.get(temp)) {
          if (distArr[temp] + nei.weigth < distArr[nei.vertex]) {
            distArr[nei.vertex] = distArr[temp] + nei.weigth;
          }
        }
      }
    }

    System.out.println(
        "yup: distance Arr from src " + src + ", to other nodes: " + Arrays.toString(distArr));
  }

  private static void dfsHelper(int vertex,
      boolean[] visited,
      List<List<Node>> adjList,
      Stack<Integer> stack) {
    visited[vertex] = true;
    for (Node nei : adjList.get(vertex)) {
      if (!visited[nei.vertex]) {
        dfsHelper(nei.vertex, visited, adjList, stack);
      }
    }
    stack.push(vertex);
  }

  public static void main(String[] args) {
    List<List<Node>> adjList = new ArrayList<>();
    adjList.add(Arrays.asList(new Node(1, 2), new Node(4, 1)));
    adjList.add(Arrays.asList(new Node(2, 3)));
    adjList.add(Arrays.asList(new Node(3, 6)));
    adjList.add(new ArrayList<>());
    adjList.add(Arrays.asList(new Node(2, 2), new Node(5, 4)));
    adjList.add(Arrays.asList(new Node(3, 1)));
    shortestPath(adjList, 6,
        0);  //  yup: distance Arr from src 0, to other nodes: [0, 2, 3, 6, 1, 5]
  }
}
