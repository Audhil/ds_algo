package _14Graphs._Striver;

import java.util.LinkedList;
import java.util.Queue;

//  https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=10&ab_channel=takeUforward
public class _6RottonOrangesM {

  //  TC: O (m * n)
  //  SC: O (m * n)
  private static class Pair {

    int row, col, tm;

    public Pair(int row, int col, int tm) {
      this.row = row;
      this.col = col;
      this.tm = tm;
    }
  }

  //  0 - no orange, 1 - fresh orange, 2 - rotton orange

  private static final int _0NoOrange = 0;
  private static final int _1FreshOrange = 1;
  private static final int _2RottonOrange = 2;

  private static final int[] dirX = {-1, 0, 1, 0};
  private static final int[] dirY = {0, -1, 0, 1};

  //  use BFS
  private static int rottonOranges(int[][] oranges) {
    //  1. create visited array, fill the queue
    int rows = oranges.length;
    int cols = oranges[0].length;
    int[][] visited = new int[rows][cols];
    int freshCount = 0;
    Queue<Pair> queue = new LinkedList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        //  is it a rotton orange
        if (oranges[i][j] == _2RottonOrange) {
          queue.add(new Pair(i, j, 0));
          visited[i][j] = _2RottonOrange;
        }
        if (oranges[i][j] == _1FreshOrange) {
          freshCount++;
        }
      }
    }
    //  2. bfs
    int cnt = 0;
    int tm = 0;
    while (!queue.isEmpty()) {
      Pair item = queue.poll();
      tm = Math.max(tm, item.tm);
      for (int i = 0; i < 4; i++) {
        int nrow = item.row + dirX[i];
        int ncol = item.col + dirY[i];
        if (nrow >= 0 && nrow < rows
            && ncol >= 0 && ncol < cols
            && visited[nrow][ncol] == _0NoOrange
            && oranges[nrow][ncol] == _1FreshOrange) {
          queue.add(new Pair(nrow, ncol, item.tm + 1));
          visited[nrow][ncol] = _2RottonOrange;
          cnt++;
        }
      }
    }

    //  3. final result
    if (freshCount == cnt) {
      return tm;
    }
    return -1;
  }

  public static void main(String[] args) {
//    int[][] oranges = {{0, 1, 2}, {0, 1, 1}, {2, 1, 1}};
//    System.out.println("yup: time taken to rot all the oranges: " + rottonOranges(
//        oranges));  //  yup: time taken to rot all the oranges: 2

    int[][] oranges = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
    System.out.println("yup: time taken to rot all the oranges: " + rottonOranges(
        oranges));  //  yup: time taken to rot all the oranges: 1
  }
}
