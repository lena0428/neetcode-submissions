class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int i) {
        if (i == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
    
        if (board[x][y] != word.charAt(i)) {
            return false;
        }
        visited[x][y] = true;
        boolean result = false;
        result |= dfs(board, visited, word, x + 1, y, i + 1);
        result |= dfs(board, visited, word, x - 1, y, i + 1);
        result |= dfs(board, visited, word, x, y + 1, i + 1);
        result |= dfs(board, visited, word, x, y - 1, i + 1);
        visited[x][y] = false;
        return result;
    }
}
