package _14Graphs._Striver._10ShortestDistance_ShortestPath._3DijikstrasAlgo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//  https://www.youtube.com/watch?v=amvrKlMLuGY&ab_channel=NeetCode
public class _5SwimInRisingWater_DijikstrasAlgo {

  private static class Node {

    int r, c, t;  //  row, col, time/maxHeight

    public Node(int r, int c, int t) {
      this.r = r;
      this.c = c;
      this.t = t;
    }
  }

  public static int swimInWater(int[][] grid) {
    int n = grid.length;
    Set<Integer> visited = new HashSet<>();
    Queue<Node> minHeap = new PriorityQueue<>((a, b) -> a.t - b.t);
    minHeap.add(new Node(0, 0, grid[0][0])); //  add 0,0 with required t or maxHeight
    visited.add((0 * n) + 0); //  r * n + c;  //  flattening 2d to 1d array
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    int t = -1;
    while (!minHeap.isEmpty()) {
      Node temp = minHeap.poll();
      int r = temp.r;
      int c = temp.c;
      t = temp.t;

      //  it'll definitely reach this condition
      if (r == n - 1 && c == n - 1) {
        return t;
      }

      for (int i = 0; i < 4; i++) {
        int nr = r + dirX[i];
        int nc = c + dirY[i];
        if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited.contains((nr * n) + nc)) {
          continue;
        }
        minHeap.add(new Node(nr, nc,
            Math.max(t, grid[nr][nc]))); //  always push maximum t/maxHeight of the node on the way
        visited.add((nr * n) + nc);
      }
    }
    return t;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: swimInWater: " + swimInWater(new int[][]{{0, 2}, {1, 3}}));  //  yup: swimInWater: 3
    System.out.println("yup: swimInWater: " + swimInWater(
        new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16},
            {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));  //  yup: swimInWater: 16
  }
}
