class Solution {
    public int trap(int[] height) {
        // 1 0 2 3
        // 0 1 1 2 leftMax
        // 3 3 3 0 rightMax
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int leftM = height[0];
        int rightM = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = leftM;
            leftM = Math.max(leftM, height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = rightM;
            rightM = Math.max(rightM, height[i]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int trap = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (trap > 0) {
                res += trap;
            }
        }
        return res;
    }
}
