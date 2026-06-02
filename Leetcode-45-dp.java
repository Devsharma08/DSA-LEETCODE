// with dynamic programming
class Solution {
    public int jump(int[] nums) {
        int max = 0 ;
        int len = nums.length-1;
        if(len==1 && nums[0]==0) return 0;
        if(len==1 && nums[0]>0) return 1;
        int[] arr = new int[len+1];
        Arrays.fill(arr, 99999);
        arr[len] = 0 ;
        for(int i = len-1 ; i >= 0 ; i--){
            // int count = 0 ;
            
            for(int j = nums[i] ; j > 0 ; j-- ){
                if( i + j <= len){
                    int count = 1 + arr[j+i];
                    arr[i] = Math.min(count,arr[i]);
                }
            }
            
        }

        return arr[0];
        
    }
}