class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
       
        int totalSubsets = 1 << len;
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> currentSubset = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    currentSubset.add(nums[j]);
                }
            }
            result.add(currentSubset);
        }
        
        return result;
    }
}