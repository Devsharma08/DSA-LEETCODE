class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = ((n+1) * ( n )) / 2 ;
        for(int i = 0 ; n > i ; i++){
            totalSum = totalSum - nums[i];
        }
        return totalSum;
    }
}