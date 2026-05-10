class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp < 0) {
                tmp = 0;
            }
            tmp += nums[i];
            sum = Math.max(sum, tmp);
        }
        return sum;
    }
}
