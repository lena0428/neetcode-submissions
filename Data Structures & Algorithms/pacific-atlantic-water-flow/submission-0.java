class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visitedPacific = new boolean[heights.length][heights[0].length];
        boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            bfs(heights, visitedPacific, i, 0);
            bfs(heights, visitedAtlantic, i, heights[0].length - 1);
        }
        for (int j = 0; j < heights[0].length; j++) {
             bfs(heights, visitedPacific, 0, j);
             bfs(heights, visitedAtlantic, heights.length - 1,j);
        }
        List<List<Integer>> result = new ArrayList<>();                               
        for (int i = 0; i < heights.length; i++) {                                    
            for (int j = 0; j < heights[0].length; j++) {                             
                if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    result.add(Arrays.asList(i, j));                                  
                }                                                                   
            }
        }
        return result;

    }

    public void bfs(int[][] heights, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        int[][] move = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            visited[tmp[0]][tmp[1]] = true;
            for (int i = 0; i < 4; i++) {
                int mX = tmp[0] + move[i][0];
                int mY = tmp[1] + move[i][1];
                if (mX < 0 || mY < 0 || mX >= heights.length || mY >= heights[0].length) {
                    continue;
                }
                if (visited[mX][mY]) {
                    continue;
                }
                if (heights[mX][mY] >= heights[tmp[0]][tmp[1]]) {
                    queue.offer(new int[]{mX, mY});
                }
            }
        
    }
}
}
