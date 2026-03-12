class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int i : nums){
            pq.offer(i);
        }
        int j = 0 ;
        int ans = 0 ;
        while(j!=k){
            ans = pq.poll();
            j++;
        }

        return ans;
    }
}