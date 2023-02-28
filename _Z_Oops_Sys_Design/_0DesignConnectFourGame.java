package _Z_Oops_Sys_Design;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  https://neetcode.io/courses/ood-interview/0
public class _0DesignConnectFourGame {

  //  grid pos
  private enum GridCell {
    Empty, Yellow, Red;
  }

  //  grid class
  private static class Grid {

    private final int rows;
    private final int cols;
    private int[][] grid;

    public Grid(int rows, int cols) {
      this.rows = rows;
      this.cols = cols;
      initGrid();
    }

    private void initGrid() {
      grid = new int[rows][cols];
    }

    private int placePiece(int col, GridCell piece) {
      if (piece == GridCell.Empty) {
        throw new Error("Invalid Piece");
      } else if (col < 0 || col >= cols) {
        throw new Error(("Invalid Place"));
      }
      for (int row = rows - 1; row >= 0; row--) {
        if (grid[row][col] == GridCell.Empty.ordinal()) {
          grid[row][col] = piece.ordinal();
          return row;
        }
      }
      throw new Error("Something went wrong!");
    }

    private boolean checkWin(int checkN, int row, int col, GridCell piece) {
      int count = 0;
      //  check horizontal
      for (int c = 0; c < cols; c++) {
        if (grid[row][c] == piece.ordinal()) {
          count += 1;
        } else {
          count = 0;
        }
        if (count == checkN) {
          return true;
        }
      }
      count = 0;
      //  check vertical
      for (int r = 0; r < rows; r++) {
        if (grid[r][col] == piece.ordinal()) {
          count += 1;
        } else {
          count = 0;
        }
        if (count == checkN) {
          return true;
        }
      }
      count = 0;
      //  check diagonal
      for (int r = 0; r < rows; r++) {
        int c = row + col - r;
        if (c >= 0 && c < cols && grid[r][c] == piece.ordinal()) {
          count += 1;
        } else {
          count = 0;
        }
        if (count == checkN) {
          return true;
        }
      }
      count = 0;
      //  check anti-diagonal
      for (int r = 0; r < rows; r++) {
        int c = col - row + r;
        if (c >= 0 && c < cols && grid[r][c] == piece.ordinal()) {
          count += 1;
        } else {
          count = 0;
        }
        if (count == checkN) {
          return true;
        }
      }
      return false;
    }

    public int[][] getGrid() {
      return grid;
    }
  }

  //  player class
  private static class Player {

    private final String name;
    private final GridCell piece;

    public String getName() {
      return name;
    }

    public GridCell getPiece() {
      return piece;
    }

    public Player(String name, GridCell piece) {
      this.name = name;
      this.piece = piece;
    }
  }

  //  Game class
  private static class Game {

    private final Player[] players;
    private final Grid grid;

    private final int targetScore, connectN;

    private final Map<String, Integer> scoreMap;

    public Game(Player[] players, Grid grid, int connectN, int targetScore) {
      this.players = players;
      this.grid = grid;
      this.connectN = connectN;
      this.targetScore = targetScore;
      this.scoreMap = new HashMap<>();
      for (Player pla : players) {
        scoreMap.put(pla.name, 0);
      }
    }

    private MovedRowCol playMove(Player player) {
      printBoard();
      System.out.println("Enter 0 to " + (grid.cols - 1) + ", value");
      Scanner sc = new Scanner(System.in);
      int movedCol = sc.nextInt();
      int movedRow = grid.placePiece(movedCol, player.piece);
      return new MovedRowCol(movedRow, movedCol);
    }

    private Player playRound() {
      while (true) {
        for (Player player : players) {
          System.out.println(player.name + "'s turn");
          MovedRowCol pos = playMove(player);
          if (grid.checkWin(connectN, pos.movedRow, pos.movedCol, player.piece)) {
            System.out.println(player.name + ", won the round");
            scoreMap.put(player.name, scoreMap.getOrDefault(player.name, 0) + 1);
            return player;
          }
        }
      }
    }

    private void printBoard() {
      System.out.println("Board:");
      int[][] grid = this.grid.getGrid();
      for (int i = 0; i < grid.length; i++) {
        String row = "";
        for (int piece : grid[i]) {
          if (piece == GridCell.Empty.ordinal()) {
            row += "0 ";
          } else if (piece == GridCell.Yellow.ordinal()) {
            row += "Y ";
          } else if (piece == GridCell.Red.ordinal()) {
            row += "R ";
          }
        }
        System.out.println(row);
      }
      System.out.println();
    }

    private void play() {
      int maxScore = 0;
      Player winner = null;
      while (maxScore < targetScore) {
        winner = playRound();
        maxScore = Math.max(maxScore, scoreMap.get(winner.name));
        grid.initGrid(); // reset grid
      }
      if (winner != null) {
        System.out.println("yup: " + winner.name + ", won the match!");
      }
    }
  }

  //  helper class
  private static class MovedRowCol {

    private final int movedRow, movedCol;

    public MovedRowCol(int movedRow, int movedCol) {
      this.movedRow = movedRow;
      this.movedCol = movedCol;
    }
  }

  public static void main(String[] args) {
    Grid grid = new Grid(3, 3);
    Player[] players = new Player[]{new Player("Audhil", GridCell.Yellow),
        new Player("Mehtab", GridCell.Red)};
    Game game = new Game(players, grid, 3, 2);
    game.play();
  }

  /*
  * Audhil's turn
      Board:
      0 0 0
      0 0 0
      0 0 0

      Enter 0 to 2, value
      1
      Mehtab's turn
      Board:
      0 0 0
      0 0 0
      0 Y 0

      Enter 0 to 2, value
      2
      Audhil's turn
      Board:
      0 0 0
      0 0 0
      0 Y R

      Enter 0 to 2, value
      1
      Mehtab's turn
      Board:
      0 0 0
      0 Y 0
      0 Y R

      Enter 0 to 2, value
      2
      Audhil's turn
      Board:
      0 0 0
      0 Y R
      0 Y R

      Enter 0 to 2, value
      1
      Audhil, won the round
      Audhil's turn
      Board:
      0 0 0
      0 0 0
      0 0 0

      Enter 0 to 2, value
      0
      Mehtab's turn
      Board:
      0 0 0
      0 0 0
      Y 0 0

      Enter 0 to 2, value
      2
      Audhil's turn
      Board:
      0 0 0
      0 0 0
      Y 0 R

      Enter 0 to 2, value
      1
      Mehtab's turn
      Board:
      0 0 0
      0 0 0
      Y Y R

      Enter 0 to 2, value
      2
      Audhil's turn
      Board:
      0 0 0
      0 0 R
      Y Y R

      Enter 0 to 2, value
      0
      Mehtab's turn
      Board:
      0 0 0
      Y 0 R
      Y Y R

      Enter 0 to 2, value
      2
      Mehtab, won the round
      Audhil's turn
      Board:
      0 0 0
      0 0 0
      0 0 0

      Enter 0 to 2, value
      1
      Mehtab's turn
      Board:
      0 0 0
      0 0 0
      0 Y 0

      Enter 0 to 2, value
      2
      Audhil's turn
      Board:
      0 0 0
      0 0 0
      0 Y R

      Enter 0 to 2, value
      1
      Mehtab's turn
      Board:
      0 0 0
      0 Y 0
      0 Y R

      Enter 0 to 2, value
      0
      Audhil's turn
      Board:
      0 0 0
      0 Y 0
      R Y R

      Enter 0 to 2, value
      1
      Audhil, won the round
      yup: Audhil, won the match!

      * */
}
