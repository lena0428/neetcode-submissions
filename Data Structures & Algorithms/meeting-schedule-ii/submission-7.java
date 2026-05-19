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
    // 0,          30
    //   5-10 10-20 
    // -> 2
    // order by left side
    // [0, 30] [5, 10] [10,20]
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Interval interval:intervals) {
            if (!queue.isEmpty() && queue.peek() <= interval.start) {
                queue.poll();
            }
            queue.offer(interval.end);
        }
        return queue.size();
    }
}
