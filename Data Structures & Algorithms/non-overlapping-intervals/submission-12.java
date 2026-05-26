class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (right > intervals[i][0]) {
                res++;
                right = Math.min(right, intervals[i][1]);
            } else {
                right = intervals[i][1];
            }
        }
        return res;
    }
}
