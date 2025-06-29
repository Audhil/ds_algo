package _14Graphs._Striver;

import java.util.LinkedList;
import java.util.Queue;

//  https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9&ab_channel=takeUforward
public class _5FloodFillAlgorithmM {

  //  TC: O (n * m)
  //  SC: O (n * m) + O (n * m) -> cpyImg array + auxillary space due to recursion
  private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int[][] cpyImg = image;
    int initColor = cpyImg[sr][sc];
//    dfs(cpyImg, image, sr, sc, initColor, newColor);
    bfs(cpyImg, image, sr, sc, initColor, newColor);
    return cpyImg;
  }

  private static final int[] dirX = {-1, 0, 1, 0};
  private static final int[] dirY = {0, -1, 0, 1};

  private static void dfs(int[][] cpyImg,
      int[][] image,
      int row,
      int col,
      int initColor,
      int newColor) {
    cpyImg[row][col] = newColor;
    for (int i = 0; i < 4; i++) {
      int nrow = row + dirX[i];
      int ncol = col + dirY[i];
      if (nrow >= 0 && nrow < cpyImg.length
          && ncol >= 0 && ncol < cpyImg[0].length
          && image[nrow][ncol] == initColor
          && cpyImg[nrow][ncol] != newColor) {
        dfs(cpyImg, image, nrow, ncol, initColor, newColor);
      }
    }
  }

  private static class Pair {

    int row, col;

    public Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static void bfs(int[][] cpyImg,
      int[][] image,
      int row,
      int col,
      int initColor,
      int newColor) {
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(row, col));
    while (!queue.isEmpty()) {
      Pair item = queue.poll();
      cpyImg[item.row][item.col] = newColor;
      for (int i = 0; i < 4; i++) {
        int nrow = item.row + dirX[i];
        int ncol = item.col + dirY[i];
        if (nrow >= 0 && nrow < image.length
            && ncol >= 0 && ncol < image[0].length
            && image[nrow][ncol] == initColor
            && cpyImg[nrow][ncol] != newColor) {
          queue.add(new Pair(nrow, ncol));
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] img = new int[][]{
        {1, 1, 2, 3},
        {1, 2, 1, 1},
        {3, 3, 1, 4},
    };
    System.out.println("yup: after flood fill: ");
    /*
    * yup: after flood fill:
      7 7 2 3
      7 2 1 1
      3 3 1 4
      * */
    int[][] finalImg = floodFill(img, 0, 1, 7);
    for (int i = 0; i < finalImg.length; i++) {
      for (int j = 0; j < finalImg[0].length; j++) {
        System.out.print(finalImg[i][j] + " ");
      }
      System.out.println();
    }
  }
}
