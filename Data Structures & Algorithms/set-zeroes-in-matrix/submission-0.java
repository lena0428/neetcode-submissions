class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int m = 0; m < matrix.length; m++) {
                        res[m][j] = 0;
                    }
                    for (int n = 0; n < matrix[0].length; n++) {
                        res[i][n] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}
