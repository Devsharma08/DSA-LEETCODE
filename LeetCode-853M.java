class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n==0) return 0;
        double[][] db = new double[n][2]; 

        for(int i = 0 ; n > i ; i++){
            db[i][0] = position[i];
            db[i][1] = (double)(target - position[i]) / speed[i];  
        }

        Arrays.sort(db,(a,b)->Double.compare(b[0],a[0]));
        int count = 0 ; 
        double min = 0 ;
        for(int i = 0 ; n > i ; i++){
            if(min < db[i][1]){
                count++;
                min = db[i][1];
            }
        }
        return count;
    }
}