class Solution {
    // int count = 0;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n]; 
        int count = 0 ;

        for(int i = 0 ; n > i ; i++ ){
            if(!visited[i]){
                count++;
                dfs(isConnected,visited,i);
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected,boolean[] visited,int i){
        visited[i] = true;
        for( int j = 0 ; isConnected.length > j ; j++ ){
            if( isConnected[i][j] == 1 && !visited[j] ){
                dfs(isConnected,visited,j);
            }
        }
    }
}