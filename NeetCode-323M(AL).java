class Solution {
    public int countComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // making adjacency list
        for(int i = 0 ; n > i ; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; edges.length > i ; i++){       
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        // visited array
        boolean[] visited = new boolean[n];
        int count = 0 ;

        for(int i = 0 ; n > i ; i++){
            if(!visited[i]){
                count++;
                dfs(i,list,visited);
            }
        } 
        return count;
    }
    public void dfs(int curr, ArrayList<ArrayList<Integer>> edges , boolean[] visited ){
        visited[curr] = true;
        // int len = edges.get(curr).size();
        for( int num : edges.get(curr) ){
            if( !visited[num] ){
                dfs(num,edges,visited);
            }
        }
    }
}
