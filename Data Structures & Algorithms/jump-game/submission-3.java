class Solution {
    public boolean canJump(int[] nums) {
        int range = 0;
        for (int i = 0; i < nums.length; i++) {
            if (range < i) {
                return false;
            }
            range = Math.max(range, nums[i] + i);
            if (range >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
