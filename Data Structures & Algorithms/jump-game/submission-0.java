class Solution {
    // 1
    // get to 0, get to 1
    // range(0, 1)
    // range(1, 3)
    // get to 3
    // range(3, 4) till end

    public boolean canJump(int[] nums) {
        int range = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > range) {
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
