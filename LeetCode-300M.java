class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int ans[] = new int[len];
        int count = 0 ;
        if(len==1) return 1;
        Arrays.fill(ans,1);
        for(int i = 1 ; len > i ; i++ ){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]){
                    ans[i] = Math.max(ans[i],ans[j]+1);
                }
                count = Math.max(count,ans[i]);
            }
        }
        return count;
    }
}