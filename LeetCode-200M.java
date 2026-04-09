class Solution {
    public int numIslands(char[][] grid) {
        // pick a node 
        // visit all nodes around it
        // then recursivily do this until you find nothing 
        // then check another non-visited element (2D-array)

        int count = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; grid.length > i; i++) {
            for (int j = 0; grid[0].length > j; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        // visited[row][col] = true;
        if (visited[row][col] == true && grid[row][col] == '1') {
            if (row < (grid.length - 1) && !visited[row + 1][col] && grid[row + 1][col] == '1') {
                visited[row + 1][col] = true;
                dfs(grid, visited, row + 1, col);
            } // right
            if (col < (grid[0].length - 1) && !visited[row][col + 1] && grid[row][col + 1] == '1') {
                visited[row][col + 1] = true;
                dfs(grid, visited, row, col + 1); // down
            }
            if (row > 0 && !visited[row - 1][col] && grid[row - 1][col] == '1') {
                visited[row - 1][col] = true;
                dfs(grid, visited, row - 1, col);
            } // left
            if (col > 0 && !visited[row][col - 1] && grid[row][col - 1] == '1') {
                visited[row][col - 1] = true;
                dfs(grid, visited, row, col - 1);
            } // up
        } else
            return;
    }
}