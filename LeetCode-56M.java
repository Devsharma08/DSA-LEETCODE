class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        for(int i = 0 ; intervals.length > i ; ){
            int st = intervals[i][0];
            int end = intervals[i][1];
            
            int j = i + 1 ;
            while( j < intervals.length &&  intervals[j][0] <= end ){
                end = Math.max(end,intervals[j][1]);
                j++;
            }
            list.add(new int[]{st,end});
            i = j ;
        }
        return list.toArray(new int[list.size()][2]);
    }
}