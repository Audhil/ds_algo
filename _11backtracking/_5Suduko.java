package _11backtracking;

//  https://www.youtube.com/watch?v=7SG0_U2pWR8&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=9
//  based on https://github.com/kashish098/Data-Structures-and-Algorithms/blob/master/Backtracking/6.a)Sudoku.cpp
//  ref: https://www.geeksforgeeks.org/sudoku-backtracking-7/
//  TC: O(9^n^2)
public class _5Suduko {

    private static final int N = 9;

    private static boolean solveSudoku(int i, int j, int[][] grid) {    //  i - row, j - col
        if (i == N - 1 && j == N)
            return true;

        if (j == N) {
            i++;
            j = 0;
        }

        //  if the cell is already filled with value, do next iteration
        if (grid[i][j] != 0)
            return solveSudoku(i, j + 1, grid);

        //  if the cell is empty, try values from 1 .. 9
        for (int k = 1; k <= N; k++) {
            if (isValid(i, j, grid, k)) {
                grid[i][j] = k;
                if (solveSudoku(i, j + 1, grid))
                    return true;
            }
            grid[i][j] = 0;
        }
        return false;
    }

    //  1. row constraint
    //  2. column constraint
    //  3. grid constraint
    private static boolean isValid(int i, int j, int[][] grid, int k) {
        return rowValid(i, grid, k) && colValid(j, grid, k) && subGridValid(i, j, grid, k);
    }

    //  3. sub grid constraint
    private static boolean subGridValid(int i, int j, int[][] grid, int k) {
        for (int l = 0; l < N; l += 3) {
            int rStart = 0, rEnd = 0, cStart = 0, cEnd = 0;
            if (i >= l && i < l + 3) {
                rStart = l;
                rEnd = l + 3;
            }
            if (j >= l && j < l + 3) {
                cStart = l;
                cEnd = l + 3;
            }
            for (int m = rStart; m < rEnd; m++) {
                for (int n = cStart; n < cEnd; n++) {
                    if (grid[m][n] == k)
                        return false;
                }
            }
        }
        return true;
    }

    //  2. col constraint
    private static boolean colValid(int j, int[][] grid, int k) {
        for (int l = 0; l < N; l++) {
            if (grid[l][j] == k)
                return false;
        }
        return true;
    }

    //  1. row constraint
    private static boolean rowValid(int i, int[][] grid, int k) {
        for (int l = 0; l < N; l++) {
            if (grid[i][l] == k)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] sudokoGrid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.print(sudokoGrid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("yup: solved? : " + solveSudoku(0, 0, sudokoGrid));
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.print(sudokoGrid[row][col] + " ");
            }
            System.out.println();
        }

        /*
        * solution:
        *   3 1 6 5 7 8 4 9 2
            5 2 9 1 3 4 7 6 8
            4 8 7 6 2 9 5 3 1
            2 6 3 4 1 5 9 8 7
            9 7 4 8 6 3 1 2 5
            8 5 1 7 9 2 6 4 3
            1 3 8 9 4 7 2 5 6
            6 9 2 3 5 1 8 7 4
            7 4 5 2 8 6 3 1 9
        * */
    }
}
