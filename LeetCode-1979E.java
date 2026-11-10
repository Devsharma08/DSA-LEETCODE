class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE ; 
        int max = Integer.MIN_VALUE;
        for(int temp : nums){
            max = max > temp ? max : temp ;
            min = min > temp ? temp : min ; 
        }   
        return gcd(max,min);
    }

    public static int gcd(int a , int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}