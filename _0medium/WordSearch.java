package _0medium;

//  https://leetcode.com/problems/word-search/
/*
https://www.youtube.com/watch?v=m9TrOL1ETxI

* Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
* */
public class WordSearch {

    private static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord(int i, int j, int index, String word, char[][] board) {
        if (index == word.length())
            return true;

        if (i < 0 || i >= board.length
                || j < 0 || j >= board[i].length
                || word.charAt(index) != board[i][j]
                || visited[i][j]
        ) return false;

        visited[i][j] = true;
        if (searchWord(i + 1, j, index + 1, word, board)
                || searchWord(i - 1, j, index + 1, word, board)
                || searchWord(i, j + 1, index + 1, word, board)
                || searchWord(i, j - 1, index + 1, word, board))
            return true;
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println("yup: " + exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println("yup: " + exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
