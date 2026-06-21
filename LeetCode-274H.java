import java.util.PriorityQueue;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (int c : citations) {
            queue.add(c);
        }
        for (int i = 0; i < n; i++) {
            int currentCitation = queue.poll();
            int papersRemaining = n - i;
            if (currentCitation >= papersRemaining) {
                return papersRemaining;
            }
        }
        
        return 0;
    }
}