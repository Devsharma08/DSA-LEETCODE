class Solution {

    public void dfs(int r,int c,boolean[][] visited,int prevVal,int[][] heights ){
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || 
            visited[r][c] || heights[r][c] < prevVal) {
            return;
        }
        visited[r][c] = true;
        dfs(r + 1, c, visited, heights[r][c], heights);
        dfs(r - 1, c, visited, heights[r][c], heights);
        dfs(r, c + 1, visited, heights[r][c], heights);
        dfs(r, c - 1, visited, heights[r][c], heights);

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length; 
        int c = heights[0].length; 

        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pac = new boolean[r][c];
        boolean[][] alt = new boolean[r][c];

        // horizontal parsing
        for(int i = 0 ; c > i;i++){
            dfs(0,i,pac,heights[0][i],heights);
            dfs(r-1,i,alt,heights[r-1][i],heights);
        }

        // vertical parsing
        for(int i = 0 ; r > i;i++){
            dfs(i,0,pac,heights[i][0],heights);
            dfs(i,c-1,alt,heights[i][c-1],heights);
        }

        for(int i= 0 ; r > i ; i++){
            for(int j = 0 ; c > j ;j++){
                if(alt[i][j] && pac[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
       return result;
    }
}