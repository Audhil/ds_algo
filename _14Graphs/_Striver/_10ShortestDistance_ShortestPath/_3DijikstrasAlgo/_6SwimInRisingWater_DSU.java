package _14Graphs._Striver._10ShortestDistance_ShortestPath._3DijikstrasAlgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//  https://www.youtube.com/watch?v=u9kpzospnLM&ab_channel=RiddhiDutta
//  https://www.youtube.com/watch?v=SON551VQ76g&ab_channel=RiddhiDutta - with dijkstra algo
public class _6SwimInRisingWater_DSU {

  //  TC: O (N log N)
  private static class DSU {

    private final int[] parent;
    private final int[] rank;

    public DSU(int noOfVertices) {
      parent = new int[noOfVertices];
      rank = new int[noOfVertices];
      for (int i = 0; i < noOfVertices; i++) {
        parent[i] = i;
        rank[i] = 0;
      }
    }

    private int find(int node) {
      if (parent[node] == node) {
        return node;
      }
      return parent[node] = find(parent[node]);
    }

    private void union(int u, int v) {
      int setOfU = find(u);
      int setOfV = find(v);
      if (rank[setOfU] > rank[setOfV]) {
        parent[setOfV] = setOfU;
        rank[setOfU] += rank[setOfV];
      } else {
        parent[setOfU] = setOfV;
        rank[setOfV] += rank[setOfU];
      }
    }
  }

  public static int swimInWater(int[][] grid) {
    //  1. compress 2d to 1d array
    List<Integer> positions = new ArrayList<>();
    int n = grid.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        positions.add(i * n + j); //  compressing
      }
    }
    //  2. sort positions based on grid values
    positions.sort(Comparator.comparingInt(a ->
        grid[a / n][a
            % n]));  //  Collections.sort(positions, (a, b) -> grid[a / n][a % n] - grid[b / n][b % n]); -> "a / n" is row, "a % n" is col
    //  3.  Union / find
    DSU dsu = new DSU(n * n);
    int[] dirX = {0, -1, 0, 1};
    int[] dirY = {1, 0, -1, 0};
    for (int position : positions) {
      int r = position / n;
      int c = position % n;
      for (int i = 0; i < 4; i++) {
        int nr = r + dirX[i];
        int nc = c + dirY[i];

        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[r][c] > grid[nr][nc]) {
          dsu.union(position, nr * n + nc); //  union positions together
        }
        //  is both 0,0 and n-1, n-1 are in same set?
        if (dsu.find(0) == dsu.find((n * n) - 1)) {
          return grid[r][c];
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: swimInWater: " + swimInWater(new int[][]{{0, 2}, {1, 3}}));  //  yup: swimInWater: 3
    System.out.println("yup: swimInWater: " + swimInWater(
        new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16},
            {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));  //  yup: swimInWater: 16
  }
}