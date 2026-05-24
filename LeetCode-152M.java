class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        // Track global max, and the local extrema of the previous step
        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            // Decision: Do we start a new subarray here, or extend the existing tracks?
            currentMax = Math.max(num, num * currentMax);
            currentMin = Math.min(num, num * currentMin);
            // Update our overall record
            globalMax = Math.max(globalMax, currentMax);
        }
        
        return globalMax;
    }
}