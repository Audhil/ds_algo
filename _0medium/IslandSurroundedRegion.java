package _0medium;

//  https://leetcode.com/problems/surrounded-regions/

import java.util.Arrays;

public class IslandSurroundedRegion {

    public static void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int rCount = board.length;
        int cCount = board[0].length;
        boolean[][] visited = new boolean[rCount][cCount];
        //  visit all 'O's at borders and mark them visited
        for (int row = 0; row < rCount; row++) {
            for (int col = 0; col < cCount; col++) {
                if ((row == 0 || row == rCount - 1 || col == 0 || col == cCount - 1)
                        && !visited[row][col]
                        && board[row][col] == 'O') {
                    dfs(row, col, visited, board);
                }
            }
        }

        //  mark all 'O's with 'X's
        for (int row = 1; row < rCount - 1; row++) {
            for (int col = 1; col < cCount - 1; col++) {
                if (!visited[row][col] && board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private static void dfs(int row, int col, boolean[][] visited, char[][] board) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || visited[row][col])
            return;

        visited[row][col] = true;
        dfs(row - 1, col, visited, board);
        dfs(row + 1, col, visited, board);
        dfs(row, col - 1, visited, board);
        dfs(row, col + 1, visited, board);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("yup: solved");
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}