package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  https://www.youtube.com/watch?v=rZv_jHZva34&ab_channel=takeUforward
public class _4TopologicalSort_BFS_KahnsAlgo {

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
    int[] sortedArr = topologicalSort(V, graph);
    System.out.println("yup: this is sorted array: " + Arrays.toString(
        sortedArr)); //  yup: this is sorted array: [4, 5, 0, 2, 3, 1]
  }

  //  TC: O (N + E); SC: O (N) + O (N) - queue space + in-degree array space;
  private static int[] topologicalSort(int V, Graph graph) {
    int[] topoSortArr = new int[V + 1];
    //  1. in-degree array
    int[] inDegreeArr = new int[V + 1];
    for (int i = 0; i < V + 1; i++) {
      List<Integer> neighbours = graph.adjList.get(i);
      for (int nei : neighbours) {
        inDegreeArr[nei]++;
      }
    }
    //  2. BFS
    Queue<Integer> queue = new LinkedList<>();
    //  populate all vertices whose in-degree is 0
    for (int vertex = 0; vertex < inDegreeArr.length; vertex++) {
      if (inDegreeArr[vertex] == 0) {
        queue.add(vertex);
      }
    }
    //  do the bfs
    int i = 0;
    while (!queue.isEmpty()) {
      int vertex = queue.poll();
      topoSortArr[i++] = vertex;
      List<Integer> neighbours = graph.adjList.get(vertex);
      for (int nei : neighbours) {
        inDegreeArr[nei]--;
        if (inDegreeArr[nei] == 0) {
          queue.add(nei);
        }
      }
    }
    return topoSortArr;
  }
}
