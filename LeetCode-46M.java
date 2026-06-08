class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        // boolean array to keep tracking of visiting values
        boolean[] used = new boolean[nums.length];
        backtrack(result,nums,new ArrayList<>(),used);
        return result;
    }

    public void backtrack(List<List<Integer>> result,int[] nums,List<Integer> t,boolean[] used ){

        if(t.size()==nums.length){
            // adding value to result list
            result.add(new ArrayList<>(t));
            return;
        } 

        for( int i = 0 ; nums.length > i ; i++ ){
            if(!used[i]){
            t.add(nums[i]);
            used[i] = true;
            backtrack(result,nums,t,used);
            t.remove(t.size()-1);
            used[i] = false;
            }
        }
    }
}