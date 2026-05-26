class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        Stack<Double> stack = new Stack<>();
        int res = 0;
        double prev = -1;
        for (int i = 0; i < position.length; i++) {
            stack.push((target - cars[i][0])*1.0 / cars[i][1]);
        }
        while (!stack.isEmpty()) {
            double tmp = stack.pop();
            if (tmp > prev) {
                prev = tmp;
                res++;
            }
        }
        return res;
       }
    
}
