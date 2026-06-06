class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count = 0 ;
        int prev = 0 ; 
        for( int i = 1 ; intervals.length > i ; i++ ){
            if(intervals[prev][1] > intervals[i][0]){
                if(intervals[prev][1] > intervals[i][1]){ 
                    prev = i ;
                }
                count++;
            } else{
                prev = i ;
            }
        }
        return count;
    }
}