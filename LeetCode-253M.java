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
        if (intervals == null || intervals.isEmpty()) return 0;
        int len = intervals.size();
        int[] st = new int[len]; 
        int[] end = new int[len]; 
        for( int i = 0 ; len > i ; i++ ){
            st[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(st);
        Arrays.sort(end);
        int e = 0 ;
        int rooms = 0 ; 
        for(int i = 0 ; len > i ; i++ ){
            if(st[i] < end[e]){
                rooms++;
            } else{
                e++;
            }
        }
        return rooms;
    }
}
