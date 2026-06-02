class Solution {
    public boolean mergeTriplets( int[][] triplets, int[] target ){
        int maxV[] = new int[3];
        for(int[] temp : triplets){
            if(temp[0] <= target[0] && temp[1] <= target[1] && temp[2] <= target[2] ){
                maxV[0] = Math.max(maxV[0],temp[0]);
                maxV[1] = Math.max(maxV[1],temp[1]);
                maxV[2] = Math.max(maxV[2],temp[2]);
            }
        }
        return (maxV[0]==target[0] && maxV[1]==target[1] && maxV[2]==target[2] ) ? true : false;
    }
}