class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[queue.size()];
        int v = 0;
        while (!queue.isEmpty()) {
            res[v++] = queue.poll().getKey();
        }
        return res;
    }
}
