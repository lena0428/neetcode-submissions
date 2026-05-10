class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // expand right
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            // overlap, expand, drop the max right
            if (intervals[i][0] < right) {
                right = Math.min(intervals[i][1], right);
                res++;
            } else {
                // no overlap
                right = intervals[i][1];
            }
        }
        return res;
    }
}
