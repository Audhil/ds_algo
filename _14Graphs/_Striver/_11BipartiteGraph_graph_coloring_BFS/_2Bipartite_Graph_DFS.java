package _14Graphs._Striver._11BipartiteGraph_graph_coloring_BFS;

import java.util.ArrayList;
import java.util.List;

public class _2Bipartite_Graph_DFS {

  //  TC: O (n) + O (2*E) -> traversing n nodes + visiting neighbours(degree of node - 2*E)
  //  SC: O (n) + O (n) + O (n) -> traversing n nodes + visited array + recursion stack space
  private static boolean isBipartite(
      List<List<Integer>> adjList,
      int N) {
    int[] colorArr = new int[N];
    for (int i = 0; i < N; i++) {
      colorArr[i] = -1;
    }
    //  if the graph is multi component
    for (int vertex = 0; vertex < N; vertex++) {
      if (colorArr[vertex] == -1) {
        if (!dfs(vertex, adjList, colorArr)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean dfs(int vertex, List<List<Integer>> adjList, int[] colorArr) {
    if (colorArr[vertex] == -1) {
      colorArr[vertex] = 1;
    }
    for (int nei : adjList.get(vertex)) {
      if (colorArr[nei] == -1) {
        colorArr[nei] = 1 - colorArr[vertex];
        if (!dfs(nei, adjList, colorArr)) {
          return false;
        }
      } else if (colorArr[nei] == colorArr[vertex]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int n = 7;
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }

    adjList.get(0).add(1);
    adjList.get(1).add(0);

    adjList.get(1).add(2);
    adjList.get(2).add(1);

    adjList.get(2).add(3);
    adjList.get(3).add(2);

    adjList.get(4).add(3);
    adjList.get(3).add(4);

    adjList.get(4).add(5);
    adjList.get(5).add(4);

    adjList.get(4).add(6);
    adjList.get(6).add(4);

//    this edge forms odd length cycle, hence the graph is bipartite
//    adjList.get(1).add(6);
//    adjList.get(6).add(1);

//    make this edge to make the graph bipartite -> it forms even length cycle
    adjList.get(0).add(6);
    adjList.get(6).add(0);

    System.out.println("yup: is the graph is bipartite, with DFS? : " +
        isBipartite(adjList, n)); //  yup: is the graph is bipartite? : true
  }
}
