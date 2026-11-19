class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; nums.length > i ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> sol = new ArrayList<>();

        for( Map.Entry<Integer,Integer> val : map.entrySet()){
            int key = val.getKey();
            int val1 = val.getValue();
            if(val1==1){
                sol.add(key);
            }
        }
        return sol.stream().mapToInt(Integer::intValue).toArray();
    }
}