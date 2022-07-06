package basicToACE._2recursion_backtracking._1backtracking;

//  place n queens in nxn chess board
//  https://youtu.be/exyxf_ihbhI?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=6170
public class _2NQueenProb {

  private static void placeQueen(Character[][] chessBoard, int row) {
    //  all queens placed, print board
    if (row == chessBoard.length) {
      printBoard(chessBoard);
      System.out.println();
    }
    //  start placing queen in the board
    else {
      for (int col = 0; col < chessBoard[row].length; col++) {
        if (isSafe(row, col, chessBoard)) {
          chessBoard[row][col] = 'Q';
          placeQueen(chessBoard, row + 1);
          chessBoard[row][col] = '-';
        }
      }
    }
  }

  private static boolean isSafe(int row, int col, Character[][] chessBoard) {
    int x = row, y = col;
    //  top diagonal left
    while (x >= 0 && y >= 0) {
      if (chessBoard[x][y] == 'Q') {
        return false;
      }
      x--;
      y--;
    }
    //  top straight upside
    x = row;
    y = col;
    while (x >= 0) {
      if (chessBoard[x][y] == 'Q') {
        return false;
      }
      x--;
    }
    //  top diagonal right
    x = row;
    y = col;
    while (x >= 0 && y < chessBoard[row].length) {
      if (chessBoard[x][y] == 'Q') {
        return false;
      }
      y++;
      x--;
    }
    return true;
  }

  private static void printBoard(Character[][] chessBoard) {
    for (int i = 0; i < chessBoard.length; i++) {
      for (int j = 0; j < chessBoard[i].length; j++) {
        System.out.print(chessBoard[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    //  considering 4x4 matrix
    Character[][] chessBoard = new Character[4][4];
    for (int i = 0; i < chessBoard.length; i++) {
      for (int j = 0; j < chessBoard[i].length; j++) {
        chessBoard[i][j] = '-';
      }
    }
    placeQueen(chessBoard, 0);
  }
}
