package _14Graphs._Striver;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7&ab_channel=takeUforward
public class _3NumberOfProvincesM {

  //  notes: return number of components of a graph
  //  TC: O (n) + O (V + 2*E) - outerloop + DFS time complexity - refer: https://youtu.be/ACzkVtewUYA?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&t=811
  //  SC: O (n) + O (n) -> visited array space + recursion stack space
  private static class GraphC {

    int V;
    List<List<Integer>> adjList;

    public GraphC(int v) {
      V = v;
      adjList = new ArrayList<>();
      for (int i = 0; i < v + 1; i++) {
        adjList.add(new ArrayList<>());
      }
    }

    private void addEdge(int vertex, int neighbour) {
      List<Integer> list = adjList.get(vertex);
      list.add(neighbour);
      adjList.set(vertex, list);
    }
  }

  private static int noOfProvinces(GraphC graph) {
    int count = 0;
    boolean[] visited = new boolean[graph.V + 1];
    System.out.println("yup: dfs of graph: ");
    for (int vertex = 1; vertex < graph.V + 1; vertex++) {
      if (!visited[vertex]) {
        dfs(vertex, graph, visited);
        count++;
      }
    }
    return count;
  }

  private static void dfs(int vertex, GraphC graph, boolean[] visited) {
    visited[vertex] = true;
    System.out.print(vertex + " ");
    List<Integer> children = graph.adjList.get(vertex);
    for (int child : children) {
      if (!visited[child]) {
        dfs(child, graph, visited);
      }
    }
  }

  public static void main(String[] args) {
    GraphC graph = new GraphC(8);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.addEdge(7, 8);
    /*
    * yup: dfs of graph:
      1 2 3 4 5 6 7 8
      yup: noOfProvinces: 3
      * */
    System.out.println("\nyup: noOfProvinces: " + noOfProvinces(graph));
  }
}
