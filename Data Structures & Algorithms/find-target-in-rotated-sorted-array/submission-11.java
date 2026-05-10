class Solution {
    // 1 1 1 3 4    mid < right left & right sorted
    // 1 1 3 4 1    mid > right left sorted
    // 1 3 4 1 1    mid > right left sorted
    // 3 4 1 1 1    mid == right right sorted
    // 4 1 1 1 3    mid < right right sorted

    public int search(int[] nums, int target) {
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
