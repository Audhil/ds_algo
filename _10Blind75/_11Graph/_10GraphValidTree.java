package _10Blind75._11Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//  https://www.lintcode.com/problem/178/
//  https://www.youtube.com/watch?v=bXsUuownnoQ&ab_channel=NeetCode
public class _10GraphValidTree {

  //  Graph is a tree. when,
  //  1. there is no cycle in the graph
  //  2. if all nodes are connected to at least 1 node (no separate/alone node)

  //  TC: O (V + E); SC: O (V)
  public static boolean validTree(int n, int[][] edges) {
    //  if no nodes given, it is valid tree
    if (n == 0) {
      return true;
    }
    //  adjMap - I'm not using List<List<Int>> adjList, for ease of coding
    Map<Integer, Set<Integer>> adjMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adjMap.put(i, new HashSet<>());
    }
    for (int[] edge : edges) {
      adjMap.get(edge[0])
          .add(edge[1]); //  since it is undirected graph - we are adding in both dirs
      adjMap.get(edge[1])
          .add(edge[0]); //  since it is undirected graph - we are adding in both dirs
    }
    Set<Integer> visitedSet = new HashSet<>();
    //  start the dfs from 0th(first) node
    return dfs(0, -1, visitedSet, adjMap)
        && visitedSet.size() == n;  //  visitedSet.size() == n - is all nodes visited?
  }

  private static boolean dfs(int node,
      int prev, //  parent
      Set<Integer> visitedSet,
      Map<Integer, Set<Integer>> adjMap) {
    //  is it a cycle
    if (visitedSet.contains(node)) {
      return false;
    }
    visitedSet.add(node);
    for (int nei : adjMap.get(node)) {
      if (nei == prev) {
        continue;
      }
      if (!dfs(nei, node, visitedSet, adjMap)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    //  draw map and see, is it a tree?
    System.out.println(
        "yup: validTree: " + validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));  //  true
    System.out.println(
        "yup: validTree: " + validTree(5,
            new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));  //  false
  }
}
