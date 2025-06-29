package _11backtracking._mastering_backtracking;

//  https://youtu.be/FWAIf_EVUKE
//  https://leetcode.com/problems/sudoku-solver/
public class _3SudokuSolver_H {

  //  code explanation: https://youtu.be/FWAIf_EVUKE?t=841
  public static void solveSudoku(char[][] board) {
    solve(board);
  }

  private static boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(i, j, ch, board)) {
              board[i][j] = ch;
              if (solve(board)) {
                return true;
              } else {
                board[i][j] = '.';
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isValid(int row, int col, char ch, char[][] board) {
    for (int k = 0; k < 9; k++) {
      //  check row
      if (board[k][col] == ch) {
        return false;
      }
      //  check col
      if (board[row][k] == ch) {
        return false;
      }
      //  check square
      if (board[3 * (row / 3) + (k / 3)][3 * (col / 3) + (k % 3)] == ch) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    solveSudoku(board);
    System.out.println("yup: solved sudoku is: ");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    /*
    * yup: solved sudoku is:
      5 3 4 6 7 8 9 1 2
      6 7 2 1 9 5 3 4 8
      1 9 8 3 4 2 5 6 7
      8 5 9 7 6 1 4 2 3
      4 2 6 8 5 3 7 9 1
      7 1 3 9 2 4 8 5 6
      9 6 1 5 3 7 2 8 4
      2 8 7 4 1 9 6 3 5
      3 4 5 2 8 6 1 7 9
    */
  }
}
