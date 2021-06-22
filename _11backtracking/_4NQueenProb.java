package _11backtracking;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=EG1eTU0TONo&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=7
/*
https://github.com/kashish098/Data-Structures-and-Algorithms/blob/master/Backtracking/5.a)N_queen.cpp
TC: O(n^n)
* */
public class _4NQueenProb {

    private static void solveNQueenProb(int col, int size, int[][] board, List<Integer> currArrangment, List<List<Integer>> arrangements) {
        if (col == size) {
            arrangements.add(new ArrayList<>(currArrangment));
            return;
        }
        for (int row = 0; row < size; row++) {
            if (isSafe(row, size, currArrangment)) {
                currArrangment.add(row);
                solveNQueenProb(col + 1, size, board, currArrangment, arrangements);
                currArrangment.remove(currArrangment.size() - 1);
            }
        }
    }

    private static boolean isSafe(int row, int size, List<Integer> currArrangment) {
        //  1. check all prev items in the row -> check all rows from 0 ... j-1 if we are placing at 'j'
        for (int i = 0; i < currArrangment.size(); i++) {
            if (row == currArrangment.get(i)) {
                return false;
            }
        }

        //  2. no need to check col -> since we are placing items on each column in each iteration
        //  3. check upper diagonal of prev items - (i-1, j-1) -> i--;j-- until i >= 0 && j >= 0
        int temp = row - 1;
        for (int i = currArrangment.size() - 1; i >= 0; i--) {
            if (temp <= 0)
                break;
            if (temp == currArrangment.get(i))
                return false;
            temp--;
        }
        //  4. check lower diagonal of prev items - (i+1, j-1) -> i++;j-- until i >= 0 && j>= 0
        temp = row + 1;
        for (int i = currArrangment.size() - 1; i >= 0; i--) {
            if (temp > size)
                break;
            if (temp == currArrangment.get(i))
                return false;
            temp++;
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] chessBoard = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] chessBoard = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Empty chess board: ");
        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard[row].length; col++) {
                System.out.print(chessBoard[row][col] + " ");
            }
            System.out.println();
        }
        List<List<Integer>> arrangements = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        solveNQueenProb(0, chessBoard.length, chessBoard, currList, arrangements);
        for (List<Integer> currArrangement : arrangements) {
            System.out.println(currArrangement);
            for (Integer pos : currArrangement) {
                for (int i = 0; i < chessBoard.length; i++) {
                    if (pos == i)
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
                }
                System.out.println();
            }
        }
    }
}
