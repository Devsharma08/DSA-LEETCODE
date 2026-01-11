class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> hashset = new HashSet<>();

        if(nums.length == 0) return 0;

        for(int i : nums){
            hashset.add(i);
        }

        Integer[] numList = hashset.toArray(new Integer[0]);
        Arrays.sort(numList);
        int count = 1;
        int max = 1;
        int maxSize = numList.length ;
        for(int i = 0 ; maxSize > i ; i++){
            if( maxSize > ( i + 1 ) && (numList[i]+1) == numList[i+1]){
                count++;
                continue;
            } else{
                max = Math.max(count,max);
                count = 1;
                continue;
            } 
        }
        return max;
    }
}
