class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount+1];
        Arrays.fill(ans,amount+1);
        int n = coins.length;
        // always 0 at 0 index
        ans[0] = 0;
        for(int i = 1 ; amount >= i ; i++){
            for(int j = 0 ; n > j ; j++ ){
                int coinV = coins[j];
                if(i >= coinV)
               ans[i] = Math.min(ans[i],1+ans[i-coinV]);
            }
        }
    if(ans[amount]==amount+1) return -1;
    return ans[amount];
    }
}