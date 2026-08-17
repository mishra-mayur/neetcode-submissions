class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int[][] visited, int i, int j) {
        visited[i][j] = 1;

        if (i - 1 >= 0 && visited[i-1][j] == 0 && grid[i][j] == '1') {
            dfs(grid, visited, i - 1, j);
        }
        if (j - 1 >= 0 && visited[i][j -1] == 0 && grid[i][j] == '1') {
            dfs(grid, visited, i, j - 1);
        }
        if (i + 1 < grid.length && visited[i+1][j] == 0 && grid[i][j] == '1') {
            dfs(grid, visited, i + 1, j);
        }
        if (j + 1 < grid[0].length && visited[i][j+1] == 0 && grid[i][j] == '1') {
            dfs(grid, visited, i, j + 1);
        }
    }
}
