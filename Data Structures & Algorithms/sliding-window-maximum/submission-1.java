class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            // remove the index outside the boundary
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            // remove smaller from last
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            if (right >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
            return result;

    }

}
