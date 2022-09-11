package _14Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class _6NumOfOperationsToMakeNetworkConnected_NumOfConnectedComponents_Redundant_Connection_M {

  //  alternate ways of solving the prob, using DSU
  //  refer: _12NumOfConnectedComponentsM.java, _2RedundantConnectionsM.java

  public static int makeConnected(int n, int[][] connections) {
    //  1. make adjMap
    int edges = 0;
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    for (int[] connection : connections) {
      adjMap.putIfAbsent(connection[0], new ArrayList<>());
      adjMap.get(connection[0]).add(connection[1]);

      adjMap.putIfAbsent(connection[1], new ArrayList<>());
      adjMap.get(connection[1]).add(connection[0]);
      edges++;
    }

    //  2. find num of components in the graph
    int components = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, adjMap, visited);
        components++;
      }
    }

    //  it violates the property of Min Spanning Tree : N nodes should have N-1 edges
    if (edges < n - 1) {
      return -1;
    }

    //  https://youtu.be/3JIwIRir2sM?t=1070 - find redundant edges
    //  3. find redundant edges, to connect other components if it is needed
    int redundantEdges = edges - ((n - 1) - (components - 1));
    //  return minimum edges needed to connect components : C components needs C-1 edges to connect
    if (redundantEdges >= components - 1) {
      return components - 1;
    }
    return -1;
  }

  private static void dfs(int node, Map<Integer, List<Integer>> adjMap, boolean[] visited) {
    //  if there is single unconnected component
    if (!adjMap.containsKey(node)) {
      return;
    }
    visited[node] = true;
    for (int nbr : adjMap.get(node)) {
      if (!visited[nbr]) {
        dfs(nbr, adjMap, visited);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: makeConnected: " + makeConnected(4,
            new int[][]{{0, 1}, {0, 2}, {1, 2}}));  //  yup: makeConnected: 1

    System.out.println(
        "yup: makeConnected: " + makeConnected(6,
            new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));  //  yup: makeConnected: 2

    System.out.println(
        "yup: makeConnected: " + makeConnected(6,
            new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));  //  yup: makeConnected: -1
  }
}
