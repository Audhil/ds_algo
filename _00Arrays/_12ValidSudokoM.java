package _00Arrays;

import java.util.HashSet;
import java.util.Set;

//  https://youtu.be/TjFXEUCMqI8
//  https://leetcode.com/problems/valid-sudoku/
public class _12ValidSudokoM {

  public static boolean isValidSudoku(char[][] board) {
    Set<String> hs = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.') {
          String r = 'r' + "-" + i + "-" + board[i][j];
          String c = 'c' + "-" + j + "-" + board[i][j];
//          String rc = (i / 3) + "-" + board[i][j] + "-" + (j / 3);
          String rc = (i / 3) + "-" + (j / 3) + "-" + board[i][j];
          //  Returns: true if this set did not already contain the specified element
          if (!hs.add(r) || !hs.add(c) || !hs.add(rc)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static boolean isValidSudokuRevision(char[][] board) {
    if (board == null) {
      return false;
    }
    Set<String> hSet = new HashSet<>();
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (board[r][c] != '.') {
          String rString = r + "- r -" + board[r][c];
          String cString = r + "- c -" + board[r][c];
          String rcString = (r / 3) + " - " + (c / 3) + " - " + board[r][c];
          if (!hSet.add(rString) || !hSet.add(cString) || !hSet.add(rcString)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("yup: is valid sudoko: " +
        isValidSudokuRevision(new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));  //  true

    System.out.println("yup: is valid sudoko: " +
        isValidSudokuRevision(new char[][]{
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));  //  false

    System.out.println("yup: is valid sudoko: " +
        isValidSudokuRevision(new char[][]{
            {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
            {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
            {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
            {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
            {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
            {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
            {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));  //  false
  }
}
