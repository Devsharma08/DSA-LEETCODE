// refer neetcode for explaination and practice.
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
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1 , Interval i2){
                return i1.start - i2.start ;
            }
        });
        int len = intervals.size() - 1 ;
        for(int i = 0 ; len > i ; i++ ){
            if(intervals.get(i).end > intervals.get(i+1).start){
                return false;
            }
        }
        return true;
    }
}
