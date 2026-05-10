class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        ///  1   2
        ///      2   4
        ///  1       4
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (right > intervals[i][0]) {
                res++;
                // remove the right has larger bound
                right = Math.min(intervals[i][1], right);
            } else {
               // no overlap
               right = intervals[i][1];
            }
        }
        return res;
    }
}
