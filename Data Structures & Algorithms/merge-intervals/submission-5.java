class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // if intervals have overlap, update right
        int left = intervals[0][0];
        int right = intervals[0][1];
                List<int[]> res = new ArrayList<>();

        for (int i = 1 ; i < intervals.length; i++) {
            if (right >= intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
            } else {
                // no overlap
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
          res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}
