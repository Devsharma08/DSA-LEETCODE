class Solution {
    public int countComponents(int n, int[][] edges) {
        // making 2d matric
        int[][] arr = new int[n][n];

        // seeding values into arr
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0]; 
            int v = edges[i][1]; 
    
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        // visited array
        boolean[] visited = new boolean[n];
        int count = 0 ;
        for(int i = 0 ; n > i ; i++){
            if(!visited[i]){
                count++;
                dfs(i,n,arr,visited);
            }
        } 
        return count;
    }
    public void dfs(int curr,int len , int[][] edges , boolean[] visited ){
        visited[curr] = true;
        for( int j = 0 ; len > j ; j++ ){
            if(edges[curr][j] == 1 && !visited[j] ){
                dfs(j,len,edges,visited);
            }
        }
    }
}
