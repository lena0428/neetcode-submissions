class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int dis = 0;
        int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            dis++;
            boolean visited = false;
            for (int i = 0; i < size; i++) {
               int[] tmp = queue.poll();
               for (int k = 0; k < 4; k++) {
                int tmpX = tmp[0] + move[k][0];
                int tmpY = tmp[1] + move[k][1];
                if (tmpX < 0 || tmpY < 0 || tmpX >= grid.length || tmpY >= grid[0].length) {
                    continue;
                }
                if (grid[tmpX][tmpY] == -1 || grid[tmpX][tmpY] == 0) {
                    continue;
                }
                if (grid[tmpX][tmpY] == Integer.MAX_VALUE) {
                    grid[tmpX][tmpY] = dis;
                    visited = true;
                    queue.offer(new int[]{tmpX, tmpY});
                }
               }
            }
        }

    }
}
