package _14Graphs._Striver;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=Qzf1a--rhp8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=6&ab_channel=takeUforward
public class _2DFS_Graphs {

  private static class GraphC {

    int V;
    List<List<Integer>> adjList;

    public GraphC(int V) {
      this.V = V;
      this.adjList = new ArrayList<>();
      for (int i = 0; i < V + 1; i++) {
        adjList.add(new ArrayList<>());
      }
    }

    private void addEdge(int vertex, int neighbour) {
      List<Integer> list = adjList.get(vertex);
      list.add(neighbour);
      adjList.set(vertex, list);
    }
  }

  //  TC: O (n) + O (2*E) -> traversing n nodes + visiting neighbours(degree of node - 2*E)
  //  SC: O (n) + O (n) + O (n) -> traversing n nodes + visited array + recursion stack space
  private static List<Integer> dfs(
      int startVertex,
      int V,  //  V - no nodes
      List<List<Integer>> adjList
  ) {
    List<Integer> dfsList = new ArrayList<>();
    boolean[] visited = new boolean[V + 1];
    dfsHelper(startVertex, adjList, dfsList, visited);
    return dfsList;
  }

  private static void dfsHelper(int vertex,
      List<List<Integer>> adjList,
      List<Integer> dfsList,
      boolean[] visited) {
//    System.out.print(vertex + " ");
    dfsList.add(vertex);
    visited[vertex] = true;
    List<Integer> neighboursList = adjList.get(vertex);
    for (int item : neighboursList) {
      if (!visited[item]) {
        dfsHelper(item, adjList, dfsList, visited);
      }
    }
  }

  public static void main(String[] args) {
    int V = 8;
    GraphC graph = new GraphC(V);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 5);
    graph.addEdge(2, 6);
    graph.addEdge(3, 7);
    graph.addEdge(3, 4);
    graph.addEdge(7, 8);
    graph.addEdge(4, 8);

    System.out.println("yup: dfs of graph is : " + dfs(1, V,
        graph.adjList)); //  yup: dfs of graph is : [1, 2, 5, 6, 3, 7, 8, 4]
  }
}
