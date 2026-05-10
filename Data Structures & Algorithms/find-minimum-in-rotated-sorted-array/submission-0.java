class Solution {
    // 1 2 3  mid < right left min
    // 2 3 1  mid > right right min
    // 3 1 2  mid < right mid
    //
    // 1 2 3 left = 0 right = 2
    //       mid = 1
    //       right = mid = 1
    //     left = 0
    // mid =  0

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
