class Solution {
    public int maxProduct(int n) {
        int num1 = 0 , num2 = 0 ;
        while( n > 0 ){
            int rem = n%10;
            if(num1 < rem ){
                if(num2 < num1 ) num2 = num1;
                num1 = rem;
            }
            else if(num2 < rem) {
                num2 = rem;
            }
            n = n/10;
        }
        return num1 * num2;
    }
}