class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // left is sorted, look right boundary
        int right = intervals[0][1];
        int left = intervals[0][0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // find overlap, right >= intervals[i][0]
            if (intervals[i][0] <= right) {
                right = Math.max(intervals[i][1], right);
            } else {
                res.add(new int[]{left, right});
                // next
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}
