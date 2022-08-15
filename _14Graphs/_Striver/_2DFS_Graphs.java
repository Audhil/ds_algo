package _14Graphs._Striver;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=Qzf1a--rhp8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=6&ab_channel=takeUforward
public class _2DFS_Graphs {

  //  TC: O (n) + O (2*E) -> traversing n nodes + visiting neighbours(degree of node - 2*E)
  //  SC: O (n) + O (n) + O (n) -> traversing n nodes + visited array + recursion stack space
  private static List<Integer> dfs(
      int startVertex,
      int V,  //  V - no nodes
      List<List<Integer>> adjList
  ) {
    List<Integer> dfsList = new ArrayList<>();
    boolean[] visited = new boolean[V];
    dfsHelper(startVertex, adjList, dfsList, visited);
    return dfsList;
  }

  private static void dfsHelper(int vertex,
      List<List<Integer>> adjList,
      List<Integer> dfsList,
      boolean[] visited) {
    System.out.print(vertex + " ");
    dfsList.add(vertex);
    visited[vertex] = true;
    List<Integer> neighboursList = adjList.get(vertex);
    for (int item : neighboursList) {
      if (!visited[item]) {
        dfsHelper(item, adjList, dfsList, visited);
      }
    }
  }
}
