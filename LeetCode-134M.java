class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0 ;
        int len = gas.length;
        int tCost = 0 ;
        int tGas = 0 ;
        int stInd = 0 ;
        for(int i = 0 ; i < len ; i++){
            tGas = tGas + gas[i] ; 
            tCost = tCost + cost[i] ; 
            tank = tank + gas[i] - cost[i];
            if(tank < 0 ){
                stInd = i+1;
                tank = 0 ;
            }
        }
        if(tGas < tCost){
            return -1;
        }
        return stInd;
    }
}