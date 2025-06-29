package _14Graphs._Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  https://www.youtube.com/watch?v=-tgVpUgsQ5k&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=5&ab_channel=takeUforward
public class _1BFS_Graphs {

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

  //  TC: O (n) + O (2*E) -> traversing n nodes + visiting all degrees(2*E) of the node
  //  SC: O (n)
  //  BFS
  private static List<Integer> bfs(int startVertex,
      int V,  //  V - no nodes
      List<List<Integer>> adjList) {
    boolean[] visited = new boolean[V + 1];
    List<Integer> bfsResList = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startVertex);
    visited[startVertex] = true;
    while (!queue.isEmpty()) {
      int value = queue.poll();
//      System.out.print(value + " ");
      bfsResList.add(value);
      //  iterate it neighbours
      for (int i = 0; i < adjList.get(value).size(); i++) {
        int neighbour = adjList.get(value).get(i);
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.add(neighbour);
        }
      }
    }
    return bfsResList;
  }

  public static void main(String[] args) {
    int V = 5;
    GraphC graphC = new GraphC(V);
    graphC.addEdge(1, 3);
    graphC.addEdge(1, 4);
    graphC.addEdge(1, 2);
    graphC.addEdge(2, 4);
    graphC.addEdge(3, 4);
    graphC.addEdge(3, 5);
    graphC.addEdge(4, 5);
    for (int i = 0; i < graphC.adjList.size(); i++) {
      System.out.println(graphC.adjList.get(i));
    }
    System.out.println("yup: bfs of graph is : " + bfs(1, V,
        graphC.adjList));  //  yup: bfs of graph is : [1, 3, 4, 2, 5]
  }
}
