package _14Graphs._Striver;

import java.util.LinkedList;
import java.util.Queue;

//  https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&ab_channel=takeUforward
public class _4NumberOfIslandCountM {

  private static int numOfIsland(char[][] chars) {
    int rows = chars.length;
    int cols = chars[0].length;

    boolean[][] visited = new boolean[rows][cols];

    int count = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (chars[row][col] == '1' && !visited[row][col]) {
          bfs(row, col, chars, visited);
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs(int row, int col, char[][] chars, boolean[][] visited) {
    if (row < 0 || row >= chars.length
        || col < 0 || col >= chars[0].length
        || visited[row][col]
        || chars[row][col] == '0') {
      return;
    }
    visited[row][col] = true;
    dfs(row - 1, col, chars, visited);
    dfs(row + 1, col, chars, visited);
    dfs(row, col - 1, chars, visited);
    dfs(row, col + 1, chars, visited);
  }

  private static class Pair {

    int row, col;

    public Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static void bfs(int row, int col, char[][] chars, boolean[][] visited) {
    Queue<Pair> queue = new LinkedList<>();
    visited[row][col] = true;
    queue.add(new Pair(row, col));
    while (!queue.isEmpty()) {
      Pair item = queue.poll();
      //  traverse neighbours
      int[] dirX = {-1, 0, 1, 0};
      int[] dirY = {0, 1, 0, -1};
      for (int i = 0; i < 4; i++) {
        int nrow = item.row + dirX[i];
        int ncol = item.col + dirY[i];
        if (nrow >= 0 && nrow < chars.length
            && ncol >= 0 && ncol < chars[0].length
            && !visited[nrow][ncol]
            && chars[nrow][ncol] == '1') {
          visited[nrow][ncol] = true;
          queue.add(new Pair(nrow, ncol));
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("yup: with DFS : numOfIsland: " + numOfIsland(new char[][]{
        {'0', '1', '1', '0'},
        {'0', '1', '1', '0'},
        {'0', '0', '1', '0'},
        {'0', '0', '0', '0'},
        {'1', '1', '0', '1'}
    }));  //  yup: DFS numOfIsland: 3

    System.out.println("yup: with BFS : numOfIsland: " + numOfIsland(new char[][]{
        {'0', '1', '1', '0'},
        {'0', '1', '1', '0'},
        {'0', '0', '1', '0'},
        {'0', '0', '0', '0'},
        {'1', '1', '0', '1'}
    }));  //  yup: BFS numOfIsland: 3
  }
}
