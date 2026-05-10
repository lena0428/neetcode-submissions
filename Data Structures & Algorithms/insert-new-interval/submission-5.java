class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // |intervals[0]   |  intervals[1]|   
        //               newInterval[0]    newInterval[1]
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < n && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
