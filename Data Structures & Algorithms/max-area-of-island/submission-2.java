class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxIsland = Math.max(maxIsland, dfs(grid, i, j));
                }
            }
        }
        return maxIsland;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;

        int size = 1;

        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            size += dfs(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            size += dfs(grid, i - 1, j);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            size += dfs(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            size += dfs(grid, i, j - 1);
        }
        return size;
    }
}
