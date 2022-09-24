package _11backtracking._mastering_backtracking;

//  https://youtu.be/PC0lSbDN2gY?t=6251
public class _1NQueensProb {

  public static void main(String[] args) {
    //  yup: NQueen prob:
    //  [0,1][1,3][2,0][3,2]
    //  [0,2][1,0][2,3][3,1]
    System.out.println("yup: NQueen prob: ");
    NQueen(new boolean[4][4], 0, 0, 4, 0, "");
  }

  private static void NQueen(
      boolean[][] board,
      int row,
      int col,
      int noOfQs,
      int totQsPlaced,
      String ans) {
    if (totQsPlaced == noOfQs) {
      System.out.println(ans);
      return;
    }
    if (col >= board[0].length) {
      row++;
      col = 0;
    }
    if (row >= board.length) {
      return;
    }
    //  place the queen
    if (isSafe(board, row, col)) {
      //  do
      board[row][col] = true;
      //  recur
      NQueen(board, row, col + 1, noOfQs, totQsPlaced + 1, ans + "[" + row + "," + col + "]");
      //  undo
      board[row][col] = false;
    }
    //  not placed the queen
    NQueen(board, row, col + 1, noOfQs, totQsPlaced, ans);
  }

  private static boolean isSafe(boolean[][] board, int row, int col) {
    //  left
    int r = row;
    int c = col - 1;
    while (c >= 0) {
      if (board[r][c]) {
        return false;
      }
      c--;
    }

    //  up
    r = row - 1;
    c = col;
    while (r >= 0) {
      if (board[r][c]) {
        return false;
      }
      r--;
    }
    //  diagonal left
    r = row - 1;
    c = col - 1;
    while (r >= 0 && c >= 0) {
      if (board[r][c]) {
        return false;
      }
      r--;
      c--;
    }
    //  diagonal right
    r = row - 1;
    c = col + 1;
    while (r >= 0 && c < board[0].length) {
      if (board[r][c]) {
        return false;
      }
      r--;
      c++;
    }
    return true;
  }
}
