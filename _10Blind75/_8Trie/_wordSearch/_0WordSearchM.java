package _10Blind75._8Trie._wordSearch;

//  https://leetcode.com/problems/word-search/
//  https://www.youtube.com/watch?v=m9TrOL1ETxI&ab_channel=NickWhite
public class _0WordSearchM {

  private static boolean[][] visited;

  public static boolean exist(char[][] board, String word) {
    int row = board.length;
    int col = board[0].length;
    visited = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (word.charAt(0) == board[i][j] && find(i, j, 0, board, word)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean find(int i, int j, int index, char[][] board, String word) {
    if (index == word.length()) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[i].length
        || word.charAt(index) != board[i][j] || visited[i][j]) {
      return false;
    }

    visited[i][j] = true;

    if (find(i + 1, j, index + 1, board, word)
        || find(i - 1, j, index + 1, board, word)
        || find(i, j + 1, index + 1, board, word)
        || find(i, j - 1, index + 1, board, word)) {
      return true;
    }

    visited[i][j] = false;
    return false;
  }

  public static void main(String[] args) {
    System.out.println("yup: " + exist(
        new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
        "ABCCED"));  // true
    System.out.println("yup: " + exist(
        new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));  // true
    System.out.println("yup: " + exist(
        new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB")); // false
  }
}
