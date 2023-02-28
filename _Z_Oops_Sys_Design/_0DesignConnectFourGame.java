package _Z_Oops_Sys_Design;

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
      if (piece.ordinal() == GridCell.Empty.ordinal()) {
        throw new IllegalArgumentException("Invalid Piece");
      } else if (col < 0 || col >= cols) {
        throw new IllegalArgumentException(("Invalid Place"));
      }
      for (int row = rows - 1; row >= 0; row--) {
        if (grid[row][col] == GridCell.Empty.ordinal()) {
          grid[row][col] = piece.ordinal();
          return row;
        }
      }
      throw new IllegalArgumentException("Something went wrong!");
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
  }

  //  player class
  private static class Player {

    private final String name;
    private final GridCell piece;

    public void setScore(int score) {
      this.score = score;
    }

    private int score;

    public int getScore() {
      return score;
    }

    public String getName() {
      return name;
    }

    public GridCell getPiece() {
      return piece;
    }

    public Player(String name, GridCell piece, int score) {
      this.name = name;
      this.piece = piece;
      this.score = score;
    }
  }

  //  Game class
  private static class Game {

    private final Player[] players;
    private final Grid grid;

    private final int targetScore, connectN;

    public Game(Player[] players, Grid grid, int connectN, int targetScore) {
      this.players = players;
      this.grid = grid;
      this.connectN = connectN;
      this.targetScore = targetScore;
    }

    private MovedRowCol playMove(Player player) {
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
            player.score += 1;
            return player;
          }
        }
      }
    }

    private void play() {
      int maxScore = 0;
      Player winner = null;
      while (maxScore < targetScore) {
        winner = playRound();
        maxScore = Math.max(maxScore, winner.getScore());
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
    Player[] players = new Player[]{new Player("Audhil", GridCell.Yellow, 0),
        new Player("Mehtab", GridCell.Red, 0)};
    Game game = new Game(players, grid, 3, 2);
    game.play();
  }
}
