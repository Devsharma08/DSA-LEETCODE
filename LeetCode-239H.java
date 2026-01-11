class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] list = new int[nums.length - k + 1];

        Deque<Integer> deq = new ArrayDeque<>();
        int listInd = 0 ;
        for(int i = 0 ; nums.length > i ; i++){
            // remove too old value
            if(!deq.isEmpty() && deq.peekFirst() < (i - k + 1)){
                deq.pollFirst();
            }
            // remove all small values
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i]){
                deq.pollLast();
            }

            // adding largest index to the deq
            deq.offerLast(i);

            // adding max index to the list
            if(i >= (k -1)){
                list[listInd++] = nums[deq.peekFirst()];
            }
        }
        
        return list;
    }
}