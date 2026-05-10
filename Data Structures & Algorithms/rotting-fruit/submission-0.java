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
        int min = 0;
        int[][] move= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean spread = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            spread = false;
            // iterate all the rotten fruit
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                for (int m = 0; m < 4; m++) {
                    int mX = tmp[0] + move[m][0];
                    int mY = tmp[1] + move[m][1];
                    if (mX < 0 || mY < 0 || mX >= grid.length || mY >= grid[0].length) {
                        continue;
                    }
                    if (grid[mX][mY] == 1) {
                        spread = true;
                        grid[mX][mY] = 2;
                        queue.offer(new int[]{mX, mY});
                    }
                }
            }
            if (spread) {
                min++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min;
    }
}
