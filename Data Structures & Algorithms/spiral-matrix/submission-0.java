class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int j = top; j < bottom; j++) {
                res.add(matrix[j][right - 1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            for (int j = bottom - 1; j >= top; j--) {
                res.add(matrix[j][left]);
            }
            left++;
        }
        return res;
    }
}
