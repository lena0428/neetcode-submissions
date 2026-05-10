class Solution {
    class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
       HashMap<Pair, Integer> pairToDis = new HashMap<>();
       for (int[] point: points) {
         pairToDis.put(new Pair(point[0], point[1]), point[0] * point[0] + point[1] * point[1]);
       }
       PriorityQueue<Map.Entry<Pair,Integer>> queue = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue()
       );
       for (Map.Entry<Pair, Integer> entry: pairToDis.entrySet()) {
         queue.offer(entry);
        if (queue.size() > k) {
            queue.poll();
        }
       }
       int i = 0;
       int[][] res = new int[queue.size()][2];
       while (!queue.isEmpty()) {
        Map.Entry<Pair,Integer> tmp = queue.poll();
        res[i][0] = tmp.getKey().a;
        res[i][1] = tmp.getKey().b;
        i++;
       }
       return res;
    }
}
