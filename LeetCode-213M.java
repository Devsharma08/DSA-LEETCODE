class Solution {
    public static int r(int st,int[] nums,int n){
            if(st==0){
                n = n-1;
            }
            int f = 0;
            int s = 0;
            for(int i = st ; n > i ; i++){
                int max = Math.max(f+nums[i],s);
                f = s;
                s = max;
            }
            return Math.max(f,s);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        // assuming starting from 0th index we will get the max amount
        int i1 = r(0,nums,n);

        // assuming starting from 1th index we will get the max amount
        int i2 = r(1,nums,n);
        return Math.max(i1,i2);
    }
}