class Solution {
    public int fib(int n) {
        int fir = 0 ;
        int sec = 1 ;
        int total = 0 ;
        if(n==1) return 1;
        if(n==0) return 0;
        for( int i = 2 ; n >= i ; i++ ){
            total = sec + fir;
            fir = sec ;
            sec = total ;
        }
        return total;
    }

}