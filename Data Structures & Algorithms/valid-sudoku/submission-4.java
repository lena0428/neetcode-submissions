class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited;
        // row
        for (int i = 0; i < board.length; i++) {
            visited = new boolean[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (visited[board[i][j] - '0']) {
                    return false;
                }
                visited[board[i][j] - '0'] = true;
            }
        }
        // column
         for (int j = 0; j < board[0].length; j++) {
            visited = new boolean[10];
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (visited[board[i][j] - '0']) {
                    return false;
                }
                visited[board[i][j] - '0'] = true;
            }
        }
        // small 3 * 3 boxes
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[0].length; j+=3) {
                visited = new boolean[10];
                for (int m = i ; m < i + 3; m++) {
                    for (int n = j ; n < j + 3; n++) {
                        if (board[m][n] == '.') {
                            continue;
                        }    
                        if (visited[board[m][n] - '0']) {
                            return false;
                        }
                        visited[board[m][n] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
