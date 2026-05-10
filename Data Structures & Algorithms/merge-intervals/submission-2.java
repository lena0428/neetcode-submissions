class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int maxRight = intervals[0][1];
        int minLeft = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (maxRight >= intervals[i][0]) {
                maxRight = Math.max(maxRight, intervals[i][1]);
            } else {
                res.add(new int[]{minLeft, maxRight});
                minLeft = intervals[i][0];
                maxRight = intervals[i][1];
            }
        }
        // !!
        res.add(new int[]{minLeft, maxRight});
        return res.toArray(new int[res.size()][]);
    }
}
