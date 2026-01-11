class Solution {
    public int trap(int[] height) {

        if (height == null || height.length == 0) return 0;
        int maxLHt = height[0] , maxRHt = height[height.length - 1] ;
        int maxAr = 0 ;
        int[] maxLHtArr = new int[height.length]; 
        int[] maxRHtArr = new int[height.length]; 
        maxLHtArr[0] = height[0] ;
        maxRHtArr[ height.length - 1 ] = height[ height.length - 1] ;

        for(int i = 1 ; height.length > i ; i++){
            maxLHt = Math.max(height[i],maxLHt) ;
            maxLHtArr[i] = maxLHt ;
        }

        for(int i = ( height.length - 2 ) ; i >= 0 ; i--){
            maxRHt = Math.max(height[i],maxRHt) ;
            maxRHtArr[i] = maxRHt ;
        }

        for(int i = 0 ; height.length > i ; i++){
            maxAr +=  Math.min(maxRHtArr[i],maxLHtArr[i]) - height[i] ;
        }
        return maxAr;    
    }
}