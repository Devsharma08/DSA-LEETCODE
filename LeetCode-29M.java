class Solution {
    public int divide(int dividend, int divisor) {

        // edge case 
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long divd = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        long result = 0 ;

        while(divd >= divs){
            long temp = divs;
            int multiple = 1;
            while(divd >= (temp<<1)){ // check if multiple*divisor is less than dividend
                temp = temp<<1;
                multiple = multiple<<1;
            }

            result += multiple; // adding multiple to result
        
            divd = divd-temp;
        }
        // XOR check if same sign then false else true
        boolean isPositive = dividend<0 ^ divisor<0;
        return isPositive==false ? (int)result : -1*(int)result;
    }
}