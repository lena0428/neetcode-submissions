class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1, 2, 3, 4]
        // 2*3*4 1*3*4 1*2*4 1*2*3
        // left = 1
        //
        // 1
        // left * 1
        // left * 1 * 2
        // left * 1 * 2 * 3
        //
        // right = 1
        // 
        // 4
        // right * 4
        // 
        int left = 1;
        int right = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] *= left;
            left *= nums[i];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= right;
            right *= nums[j];
        }
        return res;
    }
}  
