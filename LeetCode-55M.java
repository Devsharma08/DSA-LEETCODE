class Solution {
    public boolean canJump(int[] nums) {
        
        int len = nums.length - 1;
        if(len+1==1) return true;
        if(nums[0]==0 && len+1>1) return false; 
        int f = len ;
        for(int i = len-1 ; i >= 0 ; i-- ){
            if( i + nums[i] >= f ){
                f = i;
            }
        }
        if(f==0) return true;
        return false;
        
    }
}