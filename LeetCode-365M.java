class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        int gcdCal = gcd(x,y);
        if(x+y<target){
            return false;
        }
        return (target % gcdCal == 0);
    }

    public static int gcd(int x, int y){
        return y==0 ? x : gcd(y,x%y);
    }
}