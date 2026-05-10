/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return true;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int leftSide = intervals.get(0).start;
        int rightSide = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (rightSide <= intervals.get(i).start) {
                rightSide = Math.max(intervals.get(i).end, rightSide);
            } else {
                return false;
            }
        }
        return true;
    }
}
