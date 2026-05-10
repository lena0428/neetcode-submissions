class Solution {
    // 0 1 2  mid < right -> left
    // 1 2 0  mid > right -> right
    // 2 0 1  mid < right -> mid
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
