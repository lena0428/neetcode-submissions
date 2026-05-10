class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        for (int num: nums) {
            if (numToFreq.containsKey(num)) {
                int count = numToFreq.get(num);
                numToFreq.put(num, count + 1);
            } else {
                numToFreq.put(num, 1);
            }
        }

        // min heap
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getValue(), b.getValue())
        );
        for (Map.Entry<Integer, Integer> entry: numToFreq.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll().getKey();
        }
        return res;
    }
}
