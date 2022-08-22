package _14Graphs._Striver;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=zQ3zgFypzX4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=12&ab_channel=takeUforward
public class _8DetectCycleInUndirectedGraph_DFS {

  //  TC: O (n + 2e) + O (n) -> TC for dfs(visit all it degrees) + for loop at line 35 in isCycle() method
  //  SC: O (n) + O (n) -> recursion stack space + visited array
  private static class GraphC {

    int V;  //  no of vertices
    List<List<Integer>> adjList;

    public GraphC(int v) {
      V = v;
      adjList = new ArrayList<>();
      for (int i = 0; i < v + 1; i++) { //  +1 for since it's 0 based index
        adjList.add(new ArrayList<>());
      }
    }

    private void addEdge(int vertex, int neighbour) {
      List<Integer> list = adjList.get(vertex);
      list.add(neighbour);
      adjList.set(vertex, list);
    }
  }

  private static boolean isCycle(
      int V,
      List<List<Integer>> adjList) {
    boolean[] visited = new boolean[V + 1];
    for (int vertex = 1; vertex < V + 1; vertex++) {
      if (!visited[vertex]) {
        if (dfs(vertex, -1, visited, adjList)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfs(int vertex,
      int parent,
      boolean[] visited,
      List<List<Integer>> adjList) {
    visited[vertex] = true;
    List<Integer> list = adjList.get(vertex);
    for (int neighbour : list) {
      if (!visited[neighbour]) {
        if (dfs(neighbour, vertex, visited, adjList)) {
          return true;
        }
      } else {
        //  https://youtu.be/zQ3zgFypzX4?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&t=624
        if (parent != neighbour) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int V = 7;
    GraphC graph = new GraphC(V);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 5);
    graph.addEdge(3, 6);
    graph.addEdge(3, 4);
    graph.addEdge(5, 7);
    graph.addEdge(6, 7);
    System.out.println(
        "yup: is Cycle present: " + isCycle(V, graph.adjList));  //  yup: is Cycle present: true

    //  multi component graph
    V = 8;
    GraphC g2 = new GraphC(V);
    g2.addEdge(1, 2);
    g2.addEdge(2, 3);
    g2.addEdge(4, 5);
//    g2.addEdge(4, 6);
    g2.addEdge(5, 6);
    g2.addEdge(7, 8);
    System.out.println(
        "yup: is Cycle present, in multi component graph: "
            + isCycle(V, g2.adjList));  //  yup: is Cycle present: false
  }
}
