class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] existed = new boolean[10];
        // row 
        for (int i = 0; i < 9; i++) {
            existed = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] =='.') {
                    continue;
                }
                if (existed[board[i][j] - '0']) {
                    return false;
                }
                existed[board[i][j] - '0'] = true;
            }
        }
        // column
        for (int i = 0; i < 9; i++) {
            existed = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] =='.') {
                    continue;
                }
                if (existed[board[j][i] - '0']) {
                    return false;
                }
                existed[board[j][i] - '0'] = true;
            }
        }
        // 3*3, [0,0],[0,3]...
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                existed = new boolean[10];
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] == '.') {
                            continue;
                        }
                        if (existed[board[m][n] - '0']) {
                             return false;
                        }
                        existed[board[m][n] - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
