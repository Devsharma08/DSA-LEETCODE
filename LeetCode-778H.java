import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[n][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        
        pq.add(new int[]{0, 0});
        visited[0][0] = true;
        
        int maxWaterLevel = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];

            maxWaterLevel = Math.max(maxWaterLevel, grid[r][c]);
            if (r == n - 1 && c == n - 1) {
                return maxWaterLevel;
            }
            
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {
                    if (!visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        pq.add(new int[]{nextR, nextC}); 
                       
                    }
                }
            }
        }
        
        return maxWaterLevel;
    }
}