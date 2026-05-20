class Solution {
    public int climbStairs(int n) {
        // array approach
        // int[] steps = new int[n];

        // vars approach
        int f = 1 ;
        int s = 1 ;

        // base conditions 
        if(n==0 || n==1){
            return 1;
        } else{
            // steps[0] = 1;
            // steps[1] = 1;
            // n = n-2;
            for(int i = 2 ; n > i ; i++){
                int t = s + f ; 
                f = s ;  
                s = t ;  
            }
            return f+s;
        }
    }
}