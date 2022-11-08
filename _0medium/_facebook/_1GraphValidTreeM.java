package _0medium._facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//  https://www.lintcode.com/problem/178/?fromId=29&_from=collection
public class _1GraphValidTreeM {

  public static boolean validTree(int n, int[][] edges) {
    Set<Integer> visited = new HashSet<>();
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }
    return dfs(0, -1, visited, adjList) && visited.size() == n;
  }

  private static boolean dfs(int node,
      int prev,
      Set<Integer> visited,
      List<List<Integer>> adjList) {
    //  we detected cycle - a tree cannot have cycle
    if (visited.contains(node)) {
      return false;
    }
    visited.add(node);
    for (int nei : adjList.get(node)) {
      if (nei == prev) {
        continue;
      }
      if (!dfs(nei, node, visited, adjList)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: isValidTree: " + validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));  //  yup: isValidTree: true
    System.out.println(
        "yup: isValidTree: " + validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {
            1, 4}})); //  yup: isValidTree: false
  }
}
