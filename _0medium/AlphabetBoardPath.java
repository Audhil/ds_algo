package _0medium;

//  https://leetcode.com/problems/alphabet-board-path/
/*
* On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].

Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
*
* board looks like,
[
*   a   b   c   d   e
*   f   g   h   i   j
*   k   l   m   n   o
*   p   q   r   s   t
*   u   v   w   x   y
*   z
* ]


We may make the following moves:

'U' moves our position up one row, if the position exists on the board;
'D' moves our position down one row, if the position exists on the board;
'L' moves our position left one column, if the position exists on the board;
'R' moves our position right one column, if the position exists on the board;
'!' adds the character board[r][c] at our current position (r, c) to the answer.
(Here, the only positions that exist on the board are positions with letters on them.)

Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.



Example 1:

Input: target = "leet"
Output: "DDR!UURRR!!DDD!"
Example 2:

Input: target = "code"
Output: "RR!DDRR!UUL!R!"


Constraints:

1 <= target.length <= 100
target consists only of English lowercase letters.
*
* */
public class AlphabetBoardPath {

    public static String alphabetBoardPath(String target) {
        if (target == null)
            return target;

        int x = 0, y = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : target.toCharArray()) {
            int d = ch - 'a';
            int row = d / 5;
            int col = d % 5;

            while (x > row) {
                x--;
                stringBuilder.append('U');
            }

            while (y > col) {
                y--;
                stringBuilder.append('L');
            }

            while (x < row) {
                x++;
                stringBuilder.append('D');
            }

            while (y < col) {
                y++;
                stringBuilder.append('R');
            }
            stringBuilder.append('!');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("yup: AlphabetBoard: " + alphabetBoardPath("zjack"));
    }
}
