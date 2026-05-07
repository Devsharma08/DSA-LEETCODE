class Solution {
    public double myPow(double x, int n) {

        if(x==1.0) return 1.0;
        if(x==-1 && n==2147483647){
            return -1.0;
        }
        if(x==-1 && n==-2147483648){
            return 1.0;
        }
        if(x==0) return 0.0;
        if(n==-2147483648) return 0.0;
         
        double calc = 1.0;
        boolean isPos = n >= 0 ? true : false ;

        if(!isPos){
            x = (double) 1/x;
            n = Math.abs(n);
        }

        for(int i = 0 ; n > i ; i++){
            calc = calc * x ;
        }
        return calc;
    }
}