class Solution {
    // 1, speed 3
    // 4, speed 2
    // (10 - 1) / 3 = 3 time
    // (10 - 4) / 2 = 3 time could catch up 1

    // 4, speed 2 time 3
    // 1, speed 2 time 5
    // 0, speed 1 time 10
    // 7, speed 1 time 3
    //
    public int carFleet(int target, int[] position, int[] speed) {
 PriorityQueue<double[]> queue = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );
        for (int i = 0; i < position.length; i++) {
 double time = (double)(target - position[i]) / speed[i];
            queue.offer(new double[]{position[i], time});        }
        double prev = -1;
        int res = 0;
        while (!queue.isEmpty()) {
            double[] a = queue.poll();
     
            if (prev < a[1]) {
                prev = a[1];
                res++;
            } 
        }
        return res;
    }
}
