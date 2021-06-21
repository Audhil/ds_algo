package _11backtracking;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=VB0b6XQUHMk&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=6
//  https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/ - 4 directions movement
//  https://www.geeksforgeeks.org/java-program-for-rat-in-a-maze-backtracking-2/    -   2 directions movement
public class _3RatInAMaze {

    private static void solvePath(int row, int col, StringBuilder currPath, List<String> paths, int size, int[][] maze) {
        if (row == size - 1 && col == size - 1) {
            paths.add(currPath.toString());
            return;
        }
        int[] row_changes = {0, -1, 0, 1};    //  corresponding x of l u r d
        int[] col_changes = {-1, 0, 1, 0};    //  corresponding y of l u r d
        char[] dirs = {'L', 'U', 'R', 'D'};
        for (int i = 0; i < 4; i++) {
            if (isSafe(row + row_changes[i], col + col_changes[i], size, maze)) {
                maze[row][col] = 0; //  block this cell
                solvePath(row + row_changes[i], col + col_changes[i], currPath.append(dirs[i]), paths, size, maze);
                maze[row][col] = 1;
                currPath.deleteCharAt(currPath.length() - 1);
            }
        }
    }

    private static boolean isSafe(int row, int col, int size, int[][] maze) {
        return row >= 0 && row < size && col >= 0 && col < size && maze[row][col] == 1;
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};    //  1 - there's way, 0 - block(No way)  //  solution: DRDDRR
        for (int[] ints : maze) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        List<String> pathList = new ArrayList<>();
        solvePath(0, 0, new StringBuilder(), pathList, maze.length, maze);
        for (String path : pathList) {
            System.out.println(path);
        }
    }
}
