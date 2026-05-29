import java.util.Arrays;

class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int x = 1; x <= target; x++) {
            int k = 1;
            int dist = (1 << k) - 1; 
            
            while (dist < x) {
                for (int j = 0; j < k; j++) {
                    int backwardDist = (1 << j) - 1;
                    int remainingDist = x - (dist - backwardDist);
                   
                    dp[x] = Math.min(dp[x], k + 1 + j + 1 + dp[remainingDist]);
                }  
                k++;
                dist = (1 << k) - 1;
            }
            if (dist == x) {
                dp[x] = Math.min(dp[x], k);
            } 
            else {
                int overshootDist = dist - x;
                dp[x] = Math.min(dp[x], k + 1 + dp[overshootDist]);
            }
        }
        
        return dp[target];
    }
}