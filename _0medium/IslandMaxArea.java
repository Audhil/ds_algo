package _0medium;

//  https://leetcode.com/problems/max-area-of-island/
public class IslandMaxArea {

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int maxArea = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] seen = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maxArea = Math.max(maxArea, area(i, j, grid, seen));
            }
        }
        return maxArea;
    }

    private static int area(int row, int col, int[][] grid, boolean[][] seen) {
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[row].length
                || grid[row][col] == 0
                || seen[row][col])
            return 0;

        seen[row][col] = true;
        return 1 + (    //  current block
                area(row - 1, col, grid, seen)  //  upper
                        + area(row + 1, col, grid, seen)    //  down
                        + area(row, col - 1, grid, seen)    //  left
                        + area(row, col + 1, grid, seen)    //  right
        );
    }

    public static void main(String[] args) {
        System.out.println("yup: maxArea: " + maxAreaOfIsland(
                new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {
                        0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }
}
