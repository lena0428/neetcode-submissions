class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum+=num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // possibility: all the number in nums
        // target: sum / 2
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        // pick nothing, sum = 0;
        dp[0] = true;
        for (int num: nums) {
            for (int j = target; j >= num; j --) {
                // choose num or not choose num
                dp[j] = dp[j - num] || dp[j];
            }
        }
        return dp[target];
    }
}
