class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int l = nums.length;
        int minSum = nums[0] + nums[1] + nums[2];

        for( int i = 0 ; l - 2 > i ; i++ ){
            int left = i+1 ;
            int right = l-1;

            while(left < right){
                int sum = nums[i]+nums[right]+nums[left];

                if(target==sum){
                    return sum;
                }

                if(Math.abs(target-minSum) > Math.abs(target-sum)) {
                    minSum = sum;
                }
                if(sum>target){
                    right--;
                } else{
                    left++;
                }

            }
        }

        return minSum;

    }
}