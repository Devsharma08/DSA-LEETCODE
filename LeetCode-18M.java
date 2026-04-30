class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for(int i = 0 ; len-3 > i ; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j = i+1 ; len-2 > j ; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int left = j+1;
                int right = len-1;

                while(right>left){
                long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                if(sum==target){
                    result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                    while(left < right && nums[left+1]==nums[left]) left++;
                    while(left < right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                if(sum < target){
                    left++;
                }
                if(sum > target){
                    right--;
                }
                }
            }
        }
        return result;
    }
}