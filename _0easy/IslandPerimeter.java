package _0easy;

//  https://www.youtube.com/watch?v=FkjFlNtTzc8
//  https://leetcode.com/problems/island-perimeter/
/*
*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
*
*
* Example 1:
* Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
*
*
Example 2:

Input: grid = [[1]]
Output: 4
*
*
Example 3:

Input: grid = [[1,0]]
Output: 4

*/
public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;

                    //  if there's land in left side
                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }

                    //  if there's land in top side
                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("yup: perimeter: " + islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        //  yup: perimeter: 16
    }
}
