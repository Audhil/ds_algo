package _11backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=TURfqTmD8UQ&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=14
//  watch video for explanation - search for given word, char by char, search ltrb + tltrblbr for next char
public class _10WordBoggle {

    public static void main(String[] args) {
        char[][] board = {{'B', 'C', 'A'}, {'C', 'H', 'E'}, {'E', 'O', 'T'}, {'S', 'S', 'P'}};
        List<String> dict = Arrays.asList("THIS", "CHESS", "HOT", "GUN");
        List<String> wordsFound = new ArrayList<>();
        for (String word : dict) {
            if (searchWord(word, board)) {
                wordsFound.add(word);
            }
        }
        System.out.println("yup: words found are: ");
        for (String word : wordsFound) {
            System.out.println(word);
        }
    }

    private static boolean searchWord(String word, char[][] board) {
        //  m x n - char matrix
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {    //  is first char of word, matches
                    if (wordBoggle(0, m, n, i, j, word, board, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean wordBoggle(int index, int m, int n, int row, int col, String word, char[][] board, boolean[][] visited) {
        //  iteration done for full word, it is found
        if (index == word.length())
            return true;

        //  iteration crosses boundary of board
        if (row < 0 || row >= m ||
                col < 0 || col >= n)
            return false;

        //  if already visited item or char not found
        if (visited[row][col] || word.charAt(index) != board[row][col])
            return false;

        visited[row][col] = true;

        //  search ltrb + tltrblbr for next char
        //  indices(i, j) are
        //  (-1, -1), (-1, 0), (-1, 1) - row before current row
        //  (0, -1), (0, 0), (0, 1) - current row
        //  (1, -1), (1, 0), (1, 1) - row after current row
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)    //  curr char is at (0,0) we can skip it
                    continue;
                if (wordBoggle(index + 1, m, n, row + i, col + j, word, board, visited))
                    return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
