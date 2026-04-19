class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        // marking the treasure chest and push it to queue

        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; rows > i; i++) {
            for (int j = 0; cols > j; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int count = queue.size();
        int inf = 2147483647;
        int[] temp;
        int r = 0;
        int c = 0;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            r = temp[0];
            c = temp[1];
            // int dis = grid[r][c];
            while (count > 0) {
                if (r < rows - 1 && c >= 0 && grid[r + 1][c] == inf) {
                    grid[r + 1][c] = grid[r][c] + 1;
                    queue.offer(new int[] {r + 1, c});
                }
                if (r > 0 && c >= 0 && grid[r - 1][c] == inf) {
                    grid[r - 1][c] = grid[r][c] + 1;
                    queue.offer(new int[] {r - 1, c});
                }
                if (r >= 0 && c < cols - 1 && grid[r][c + 1] == inf) {
                    grid[r][c + 1] = grid[r][c] + 1;
                    queue.offer(new int[] {r, c + 1});
                }
                if (r >= 0 && c > 0 && grid[r][c - 1] == inf) {
                    grid[r][c - 1] = grid[r][c] + 1;
                    queue.offer(new int[] {r, c - 1});
                }
                count--;
                // dis++;
            }
            count = queue.size();
        }
    }
}
