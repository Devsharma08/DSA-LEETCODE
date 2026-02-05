class Solution {
    public void sortColors(int[] nums) {
        // 1. declare 3 pointers curr,low,high
        // 2. st. low and current at 0 and high at len-1
        // 3. for dutch national flag algo 
        // 4. there's 3 regions where 1st regions contains least that is 0 then last regions must conatains largest number and left one will be the intermediate 
        // 5 these regions will contains all the items in sorted manner

        int low = 0 ; int curr = 0 ; int high = nums.length - 1 ;
        while(curr <= high){

            if(nums[curr] == 0){
                swap(nums,low,curr);
                low++;
                curr++;
                continue;
            }
            if(nums[curr] == 1){
                curr++;
                continue;
            }

            if(nums[curr] == 2){
                swap(nums,high,curr);
                high--;
                continue;
            } 
        }
    }
        private void swap(int nums[], int x,int y){
            int temp = nums[x] ;
            nums[x] = nums[y] ;
            nums[y] = temp ;

        }
}