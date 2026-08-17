class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int maxIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    maxIsland = Math.max(maxIsland, dfs(grid, visited, i, j));
                }
            }
        }
        return maxIsland;
    }

    private int dfs(int[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;

        int size = 1;

        if (i + 1 < grid.length && visited[i + 1][j] == 0 && grid[i + 1][j] == 1) {
            size += dfs(grid, visited, i + 1, j);
        }
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && grid[i - 1][j] == 1) {
            size += dfs(grid, visited, i - 1, j);
        }
        if (j + 1 < grid[0].length && visited[i][j + 1] == 0 && grid[i][j + 1] == 1) {
            size += dfs(grid, visited, i, j + 1);
        }
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && grid[i][j - 1] == 1) {
            size += dfs(grid, visited, i, j - 1);
        }
        return size;
    }
}
