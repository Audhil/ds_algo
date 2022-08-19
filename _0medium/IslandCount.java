package _0medium;

//  this is problem of Graph
//  https://leetcode.com/problems/number-of-islands/
//  https://www.youtube.com/watch?v=__98uL6wst8
public class IslandCount {

    //  solve with DFS
    //  complexity: O(n^2)
    public static int numIslands(char[][] grid) {
        if (grid == null)
            return 0;
        int count = 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    count++;
                    dfs(row, col, grid, visited);
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        if (row < 0 || row >= grid.length
                || col < 0 || col >= grid[0].length
                || grid[row][col] == '0'
                || visited[row][col])
            return;
        visited[row][col] = true;
        dfs(row - 1, col, grid, visited);
        dfs(row + 1, col, grid, visited);
        dfs(row, col - 1, grid, visited);
        dfs(row, col + 1, grid, visited);
    }

    public static void main(String[] args) {
        System.out.println("yup: no of islands: " +
                numIslands(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }));

        System.out.println("yup: 2nd no of islands: " +
                numIslands(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }));
    }
}
