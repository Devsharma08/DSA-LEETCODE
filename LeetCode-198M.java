class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int n = nums.length;
        // int f = nums[0] ;
        // int s = Math.max(nums[1],nums[0]) ;
        int[] ans = new int[n];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0],nums[1]);

        for(int i = 2 ; n > i ; i++ ){
            // int max = Math.max(nums[i]+ans[0],ans[1]) ;
            ans[i] = Math.max(nums[i]+ans[i-2],ans[i-1]) ;
            // f = s ;
            // s = max;
        }
        // return Math.max(f,s);
        return ans[n-1];
    }
}