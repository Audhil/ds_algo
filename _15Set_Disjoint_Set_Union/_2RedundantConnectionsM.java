package _15Set_Disjoint_Set_Union;

import java.util.Arrays;

//  https://leetcode.com/problems/redundant-connection/
public class _2RedundantConnectionsM {

  private static class DSU {

    int[] parent;
    int[] rank;

    public DSU(int numOfVertices) {
      parent = new int[numOfVertices + 1];
      rank = new int[numOfVertices + 1];
      for (int i = 0; i < numOfVertices + 1; i++) {
        parent[i] = i;
        rank[i] = 0;
      }
    }

    private int find(int x) {
      if (parent[x] == x) {
        return x;
      }
      return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
      int setOfX = find(x);
      int setOfY = find(y);
      if (setOfX != setOfY) {
        if (setOfX > setOfY) {
          parent[setOfY] = setOfX;
          rank[setOfX] += rank[setOfY];
        } else {
          parent[setOfX] = setOfY;
          rank[setOfY] += rank[setOfX];
        }
      }
    }
  }

  public static int[] findRedundantConnection(int[][] edges) {
    DSU dsu = new DSU(edges.length);
    for (int[] edge : edges) {
      int fromP = dsu.find(edge[0]);
      int toP = dsu.find(edge[1]);

      //  if both nodes, belong to same set, then it has the cycle
      if (fromP == toP) {
        return new int[]{edge[0], edge[1]};
      }
      dsu.union(edge[0], edge[1]);
    }
    return new int[0];
  }

  public static void main(String[] args) {
    System.out.println("yup: redundant edge: " + Arrays.toString(
        findRedundantConnection(
            new int[][]{{1, 2}, {1, 3}, {2, 3}}))); //  yup: redundant edge: [2, 3]

    System.out.println("yup: redundant edge: " + Arrays.toString(
        findRedundantConnection(
            new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}))); //  yup: redundant edge: [1, 4]
  }
}
