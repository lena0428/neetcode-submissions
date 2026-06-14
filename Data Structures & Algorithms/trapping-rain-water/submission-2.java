class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int leftM = 0;
        int rightM = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = leftM;
            leftM = Math.max(leftM, height[i]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = rightM;
            rightM = Math.max(rightM, height[i]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int trap = Math.min(leftMax[i], rightMax[i]);
            res += trap <= height[i] ? 0 : (trap - height[i]);
        }
        return res;
    }
}
