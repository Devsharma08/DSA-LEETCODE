class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int total = 0 ;
        for(int i = 0 ; nums.length > i ; i++ ){
            int t = nums[i];
            if(!set.add(t)){
                total = total - t ;
            } else {
                set.add(t);
                total = total + t;
            }
        }
        return total;
    }
}