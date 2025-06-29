package _14Graphs._Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  https://www.youtube.com/watch?v=BPlrALf1LDU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=12&ab_channel=takeUforward
public class _7DetectCycleInUndirectedGraph_BFS {

  //  TC: O (N + 2E) + O (N)
  //  SC: O (N)
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

  private static class GNode {

    int vertex, parent;

    public GNode(int vertex, int parent) {
      this.vertex = vertex;
      this.parent = parent;
    }
  }

  private static boolean isCycleInUnDirectedGraphWithBFS(
      int src,
      int V,
      List<List<Integer>> adjList) {
    boolean[] visited = new boolean[V + 1];
    Queue<GNode> queue = new LinkedList<>();
    queue.add(new GNode(src, -1));
    visited[src] = true;
    while (!queue.isEmpty()) {
      GNode temp = queue.poll();
      List<Integer> list = adjList.get(temp.vertex);
      for (int node : list) {
        if (!visited[node]) {
          visited[node] = true;
          queue.add(new GNode(node, temp.vertex));
        } else {
          //  https://youtu.be/BPlrALf1LDU?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&t=702
          if (temp.parent != node) {
            return true;
          }
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
        "yup: is Cycle present: " + isCycleInUnDirectedGraphWithBFS(1, V,
            graph.adjList));  //  yup: is Cycle present: true

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
            + isCycleInUnDirectedMultiComponentGraphWithBFS(V,
            g2.adjList));  //  yup: is Cycle present: false

  }

  private static boolean isCycleInUnDirectedMultiComponentGraphWithBFS(
      int V,
      List<List<Integer>> adjList) {
    boolean[] visited = new boolean[V + 1];
    for (int vertex = 1; vertex < V + 1; vertex++) {
      if (!visited[vertex]) {
        if (isCycleDetected(vertex, visited, adjList)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isCycleDetected(int src, boolean[] visited, List<List<Integer>> adjList) {
    Queue<GNode> queue = new LinkedList<>();
    queue.add(new GNode(src, -1));
    while (!queue.isEmpty()) {
      GNode temp = queue.poll();
      List<Integer> neighbourList = adjList.get(temp.vertex);
      for (int vertex : neighbourList) {
        if (!visited[vertex]) {
          visited[vertex] = true;
          queue.add(new GNode(vertex, temp.vertex));
        } else {
          if (temp.parent != vertex) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
