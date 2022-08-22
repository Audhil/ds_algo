package _14Graphs._Striver;

import java.util.LinkedList;
import java.util.Queue;

//  https://www.youtube.com/watch?v=edXdVwkYHF8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=13&ab_channel=takeUforward
//  https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-of-nearest-cell-having-1
public class _9DistanceOfNearestCell_Having_1 {

  private static class Cell {

    int r, c, dist;

    public Cell(int r, int c, int dist) {
      this.r = r;
      this.c = c;
      this.dist = dist;
    }
  }

  private static int[][] distanceOfNearestCellHaving_1(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    boolean[][] visited = new boolean[rows][cols];
    int[][] distArr = new int[rows][cols];
    Queue<Cell> queue = new LinkedList<>();
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (matrix[r][c] == 1) {
          visited[r][c] = true;
          queue.add(new Cell(r, c, 0));
        }
      }
    }
    int[] dirX = {-1, 0, 1, 0};
    int[] dirY = {0, 1, 0, -1};
    while (!queue.isEmpty()) {
      Cell item = queue.poll();
      distArr[item.r][item.c] = item.dist;
      for (int i = 0; i < 4; i++) {
        int nrow = item.r + dirX[i];
        int ncol = item.c + dirY[i];
        if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && !visited[nrow][ncol]) {
          visited[nrow][ncol] = true;
          queue.add(new Cell(nrow, ncol, item.dist + 1));
        }
      }
    }
    return distArr;
  }

  public static void main(String[] args) {
    int[][] inputArr = {
        {0, 0, 0},
        {0, 1, 0},
        {1, 0, 1}
    };

    /*
    * 2 1 2
      1 0 1
      0 1 0
    * */
    System.out.println("yup: distance of nearest 1 is : ");
    int[][] res = distanceOfNearestCellHaving_1(inputArr);
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[i].length; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }
}
