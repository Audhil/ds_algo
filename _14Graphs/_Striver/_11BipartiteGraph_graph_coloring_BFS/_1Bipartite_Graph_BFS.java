package _14Graphs._Striver._11BipartiteGraph_graph_coloring_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  https://www.youtube.com/watch?v=nbgaEu-pvkU&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=12&ab_channel=takeUforward
public class _1Bipartite_Graph_BFS {

  //  1. a graph is bipartite if it has different colors in alternate nodes, so,
  //    a. graph with odd length cycle is not the bipartite
  //    b. graph with even length cycle or graph without a cycle is a bipartite graph


  //  TC: O (V + E); SC: O (N)
  //  '0' & '1' as 2 different colors
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
        if (!bfs(vertex, adjList, colorArr)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean bfs(int node, List<List<Integer>> adjList, int[] colorArr) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    colorArr[node] = 1;
    while (!queue.isEmpty()) {
      int temp = queue.poll();
      for (int nei : adjList.get(temp)) {
        if (colorArr[nei] == -1) {
          colorArr[nei] = 1 - colorArr[temp];
          queue.add(nei);
        } else if (colorArr[nei] == colorArr[temp]) {
          return false;
        }
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
    adjList.get(1).add(6);
    adjList.get(6).add(1);

//    make this edge to make the graph bipartite -> it forms even length cycle
//    adjList.get(0).add(6);
//    adjList.get(6).add(0);

    System.out.println("yup: is the graph is bipartite? : " + isBipartite(adjList,
        n)); //  yup: is the graph is bipartite? : false
  }
}
