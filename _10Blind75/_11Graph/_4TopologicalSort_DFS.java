package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  https://www.youtube.com/watch?v=qe_pQCh09yU&ab_channel=TECHDOSE
public class _4TopologicalSort_DFS {

  /*
   * Topological sort
   * 1. it is possible only in DAG - directed acyclic graph
   * 2. all the parent node will come before their child nodes
   * 3. items with 0 or lesser in-degree will come first and
   * 4. items with 0 or lesser out-degree will come after
   * * */
  private static class Graph {

    int V;
    List<List<Integer>> adjList;

    public Graph(int v) {
      V = v;
      adjList = new ArrayList<>();
      for (int i = 0; i < V + 1; i++) {
        adjList.add(new ArrayList<>());
      }
    }

    private void addEdge(int vertex, int node) {
      adjList.get(vertex).add(node);
    }
  }

  //  TC: O (V+E)
  //  SC: O (N) + O (N) -> recursion call stack space + stack space
  private static void topologicalSort(int V, Graph graph) {
    Stack<Integer> stack = new Stack<>();
    dfs(V, graph, stack);
    /*
    * yup: after sorting:
      5
      4
      0
      3
      1
      2
      * * */
    System.out.println("yup: after sorting: ");
    while (!stack.isEmpty()) {
      System.out.println(stack.pop() + " ");
    }
  }

  private static void dfs(int V, Graph graph, Stack<Integer> stack) {
    boolean[] visited = new boolean[V + 1];
    for (int i = 0; i < V + 1; i++) {
      if (!visited[i]) {
        dfsHelper(i, graph, visited, stack);
      }
    }
  }

  private static void dfsHelper(int vertex, Graph graph, boolean[] visited, Stack<Integer> stack) {
    visited[vertex] = true;
    List<Integer> neighbours = graph.adjList.get(vertex);
    for (int nei : neighbours) {
      if (!visited[nei]) {
        dfsHelper(nei, graph, visited, stack);
      }
    }
    stack.push(vertex);
  }

  public static void main(String[] args) {
    int V = 5;
    Graph graph = new Graph(V);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(5, 0);
    graph.addEdge(5, 2);
    graph.addEdge(4, 2);
    graph.addEdge(4, 1);
    graph.addEdge(3, 1);
    topologicalSort(V, graph);
  }
}
