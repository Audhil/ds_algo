package _14Graphs._Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  https://www.youtube.com/watch?v=-tgVpUgsQ5k&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=5&ab_channel=takeUforward
public class _1BFS_Graphs {

  //  TC: O (n) + O (2*E) -> traversing n nodes + visiting all degrees(2*E) of the node
  //  SC: O (n)
  //  BFS
  private static List<Integer> bfs(int startVertex, int V, List<List<Integer>> adjList) { //  V - no nodes
    boolean[] visited = new boolean[V];
    List<Integer> bfsResList = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startVertex);
    visited[startVertex] = true;
    while (!queue.isEmpty()) {
      int value = queue.poll();
      System.out.print(value + " ");
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
}
