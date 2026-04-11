class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        // defining the rows and cols length
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        int globalMax = 0 ;
        // int = 0 ;

        // defining visited array
        boolean[][] visited = new boolean[totalRows][totalCols];


        // add loop for dfs traversal 
        for(int i = 0 ; i < totalRows ; i++){
            for(int j = 0 ; j < totalCols ; j++){
                if( grid[i][j]==1 && visited[i][j]==false )
                    globalMax = Math.max(globalMax, dfs(grid, visited, i, j));
                }
        }   
        return globalMax ;
    }

    public int dfs(int[][] grid,boolean[][] visited,int rows,int cols ){  

        if(rows < 0 || grid.length <= rows || cols < 0 || cols >= grid[0].length || grid[rows][cols]==0 || visited[rows][cols]){
            return 0;
        }
        visited[rows][cols] = true;
        return 1 + dfs(grid,visited,rows+1,cols) + dfs(grid,visited,rows,cols+1) + dfs(grid,visited,rows-1,cols) + dfs(grid,visited,rows,cols-1);
        
       
    }
}