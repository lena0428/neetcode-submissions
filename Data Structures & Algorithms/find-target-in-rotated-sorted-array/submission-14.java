class Solution {
    // 1 1 1 3 4
    // 1 1 3 4 1
    // 1 3 4 1 1
    // 3 4 1 1 1 
    // 4 1 1 1 3
    public int search(int[] nums, int target) {
        // mid <= right, right part is ascending order
        // mid > right, left part is ascending order
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
