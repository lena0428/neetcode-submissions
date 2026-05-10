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
    public int minMeetingRooms(List<Interval> intervals) {
        int[] startTime = new int[intervals.size()];
        int[] endTime = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);
        
        int count = 0;
        int s = 0;
        int e = 0;
        int res = 0;
        while (s < intervals.size()) {
            if (startTime[s] < endTime[e]) {
                count++;
                s++;
            } else {
                count--;
                e++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
