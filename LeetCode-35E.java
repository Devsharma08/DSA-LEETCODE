class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length - 1;
        
        // insert
        int high = len;
        int low = 0 ;
        int mid = low+(high-low)/2;
        while(high>=low){
            if(nums[mid]==target) return mid;
            if(target>nums[mid]) {
                low = mid+1;
            } else{
                high = mid-1;
            }
            mid = (high+low)/2;
        }
        return low;
        
    }
}