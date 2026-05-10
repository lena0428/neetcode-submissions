class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int tmp = 0;
        for (int num: nums) {
            if (tmp < 0) {
                tmp = 0;
            }
            tmp += num;
            sum = Math.max(sum, tmp);
        }
        return sum;
    }
}
