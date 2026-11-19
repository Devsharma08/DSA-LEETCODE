class Solution {
    public int[] countBits(int n) {

        int[] ans = new int[n+1];
        ans[0] = 0 ;
        for(int i = 1 ; n >= i ; i++){
            ans[i] = ans[i >> 1] + (i & 1) ;
            //
            // ans[i] = countOnes(i);
        }
        return ans;
    }
    public static int countOnes(int i){
        int count = 0 ;
        while( i > 0 ){
            if( (i % 2) != 0 ) count++;
            i = i / 2;
        }
        return count;
    }
}

