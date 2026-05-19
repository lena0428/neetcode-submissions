class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<double[]> queue = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        for (int i = 0; i < position.length; i++) {
            double time = (double)(target - position[i]) / speed[i];
            queue.offer(new double[]{position[i], time});
        }

        double prev = -1;
        int res = 0;

        while (!queue.isEmpty()) {
            double[] a = queue.poll();

            if (a[1] > prev) {
                res++;
                prev = a[1];
            }
        }

        return res;
    }
}