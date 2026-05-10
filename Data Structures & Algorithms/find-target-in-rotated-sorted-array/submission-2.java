class Solution {
    // binary search in sorting array
    // 1 2 3 4 5   mid = 3
    // 2 3 4 5 1   mid = 4  left is sorting  4 > 1  mid > right
    // 3 4 5 1 2   mid = 5 left is sorting   5 > 2
    // 4 5 1 2 3   mid = 1 right is sorting   1 < 3 mid < right
    // 5 1 2 3 4   mid = 2 right is sorting   2 < 4
    //
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } if (nums[left] <= nums[mid]) {
            // left half is sorted
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            // right half is sorted
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        }
        return -1;
    }
}
