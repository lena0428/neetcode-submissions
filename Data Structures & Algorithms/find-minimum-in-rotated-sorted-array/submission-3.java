class Solution {
    // 1 2 3   mid < right search in left
    // 2 3 1   mid > right search in right
    // 3 1 2   mid < right search in mid
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
