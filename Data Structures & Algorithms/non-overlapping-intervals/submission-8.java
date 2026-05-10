class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // overlap
            if (right > intervals[i][0]) {
                right = Math.min(intervals[i][1], right);
                res++;
            } else {
                right = intervals[i][1];
            }
        }
        return res;
    }
}
