class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        // 1. stop point of the dfs
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + dfs(grid, x - 1, y) + dfs(grid, x + 1, y)
        + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }
}
