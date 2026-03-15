class KthLargest {
    private PriorityQueue<Integer> pq ;
    private int k ;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int i : nums){
            pq.offer(i);
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        int size = pq.size();
        while(size > k){
            pq.poll();
            size--;
        }
        return pq.peek();
    }
    
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */