class Solution {
    class Pair {
        int x;
        int y;
        int val;
        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new Pair(i, j, grid[i][j]));
                }
            }
        }
        int[] moveX = {1, -1, 0, 0};
        int[] moveY = {0, 0, 1, -1};
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair tmp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = tmp.x + moveX[i];
                    int y = tmp.y + moveY[i];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                        continue;
                    }
                    if (grid[x][y] == Integer.MAX_VALUE) {
                     grid[x][y] = distance;
                        queue.offer(new Pair(x, y, grid[x][y]));                    }
                    
                }
            }
        }
    }
}
