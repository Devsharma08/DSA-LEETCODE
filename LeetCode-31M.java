class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length  == 0 || nums.length == 1) return;
        int numLen = nums.length ;
        int pivot = 0 ;
        int i = numLen - 2 ;

        while( i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }

        pivot = i ;

        if(i>=0){

        int j = nums.length - 1 ;

        while(i >= 0 && nums[pivot] >= nums[j]){
            j--;
        }

        swap(nums,pivot,j);

        }
        
        reverse(nums,pivot+1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}