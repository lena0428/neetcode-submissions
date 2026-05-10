class Solution {
        public int orangesRotting(int[][] grid) {
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            int res = 0;
            int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean spread = false;
                for (int i = 0; i < size; i++) {
                    int[] g = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int gridX = g[0] + move[k][0];
                        int gridY = g[1] + move[k][1];
                        if (gridX < 0 || gridY < 0 || gridX >= grid.length || gridY >= grid[0].length) {
                            continue;
                        }
                        if (grid[gridX][gridY] == 1) {
                            spread = true;
                            grid[gridX][gridY] = 2;
                            queue.offer(new int[]{gridX, gridY});
                        }
                    }
                }
                if (spread) {
                    res++;
                }
            }
             for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return res;
        }
}
