class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) return 0; 
        int jumps = 0;
        int currentJumpEnd = 0; 
        int farthest = 0;              
        for (int i = 0; i < len - 1; i++) {
           
            farthest = Math.max(farthest, i + nums[i]);

             if (i == currentJumpEnd) {
                jumps++;                  
                currentJumpEnd = farthest;
                if (currentJumpEnd >= len - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}