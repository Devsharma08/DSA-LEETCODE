class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int dist1 = a[0]*a[0] + a[1]*a[1];
            int dist2 = b[0]*b[0] + b[1]*b[1];
            return Integer.compare(dist2,dist1);}
        );

        for(int[] temp : points){
            pq.offer(temp);
            int size = pq.size();
            if(k<size){
                pq.poll();
            }
        }

        // pq -> array conversion 
        int[][] arr = new int[k][1];
        
        int size = pq.size();
        for(int i = 0;i<size;){
            arr[i] = pq.poll();
            i++;
        } 
        return arr;
    }
}