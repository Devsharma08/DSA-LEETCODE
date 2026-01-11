import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();

        // 1. Count Frequencies
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        // 2. Max-Heap based on Frequency
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> hash.get(b) - hash.get(a));

        // 3. FIX: Add only UNIQUE keys to the queue
        for (int key : hash.keySet()) {
            queue.offer(key);
        }

        // 4. Extract Top K
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}