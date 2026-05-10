class Solution {
    // 2 3 1 5 4
    // min heap
    // 2
    // 2 3
    // 1 2 3 -> 2 3
    // 2 3 5 -> 3 5
    // 3 5 4 -> 4 5 top
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> a - b
        );
        for (int num: nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
