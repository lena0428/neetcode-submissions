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
        // [0                      30]
        //    [5    10]
        //              [15]  [20]
        if (intervals.size() == 0) {
            return true;
        } 
        intervals.sort((a, b) -> a.start - b.start);
        int maxRight = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
           if (maxRight > intervals.get(i).start) {
            return false;
           }
           maxRight = Math.max(maxRight, intervals.get(i).end);
        }
        return true;
    }
}
