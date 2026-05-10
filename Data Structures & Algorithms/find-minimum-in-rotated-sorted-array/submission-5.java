class Solution {
    // 1 2 3
    // 2 3 1
    // 3 2 1

    // 1 1 1 3 4
    // 1 1 3 4 1
    // 1 3 4 1 1 
    // 3 4 1 1 1 
    // 4 1 1 1 3
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
