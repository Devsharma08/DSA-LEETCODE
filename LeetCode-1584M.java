import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.offer(new int[]{0, 0});
        
        int totalCost = 0;
        int edgesConnected = 0;
        
        while (!pq.isEmpty() && edgesConnected < n) {
            int[] curr = pq.poll();
            int u = curr[0];
            int cost = curr[1];
            
            if (visited[u]) continue;
            
            visited[u] = true;
            totalCost += cost;
            edgesConnected++;
            
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int distance = Math.abs(points[u][0] - points[v][0]) + 
                                   Math.abs(points[u][1] - points[v][1]);
                    pq.offer(new int[]{v, distance});
                }
            }
        }
        
        return totalCost;
    }
}