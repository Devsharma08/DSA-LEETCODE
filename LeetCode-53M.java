class Solution {
    public int maxSubArray(int[] nums) {
       int max  = nums[0] ; // can't use 0 here, [-2,-1]
       
       int curr= 0 ;
       int len = nums.length ; 
       if(len==1) return max;

       for( int i = 0 ; len > i ; i++ ){
            if(curr<0) curr= 0;
            curr = curr + nums[i];
            max = max > curr ? max : curr;

       } 
       return max;
    }
}