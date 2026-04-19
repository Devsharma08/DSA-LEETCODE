class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int nonRotten = 0 ;

        // making a queue to store position of rotton orange
        Queue<int[]> queue = new LinkedList<>();

        // first finding rotton orange
        for(int i = 0 ; grid.length > i ; i++){
            for(int j = 0 ; grid[0].length > j ; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                } 
                if(grid[i][j]==1){
                    nonRotten++;
                }
            }
        }

        // here main logic
        int[] temp  ;
        int count = queue.size();
        int minCount = 0;
        int totalCount = 0 ;
        int newTemp = 0;
        while(!queue.isEmpty()){
            count = queue.size();
            while(count>0){
                temp = queue.poll();
                int r = temp[0];
                int c = temp[1];
                if(r<m-1 && c>=0 &&grid[r+1][c]==1){
                    queue.offer(new int[] {r+1,c});
                    grid[r+1][c] = 2;
                    newTemp++;
                }
                if(r>0 && c>=0 && grid[r-1][c]==1){
                    queue.offer(new int[] {r-1,c});
                    grid[r-1][c] = 2;
                    newTemp++;
                }
                if(r>=0 && c<n-1 && grid[r][c+1]==1){
                    queue.offer(new int[] {r,c+1});
                    grid[r][c+1] = 2;
                    newTemp++;
                }
                if(r>=0 && c>0 && grid[r][c-1]==1){
                    grid[r][c-1] = 2;
                    queue.offer(new int[] {r,c-1});
                    newTemp++;
                }
                count--;
            }
            if(newTemp>0) minCount++;
            totalCount+=newTemp;
            // count = newTemp;
            newTemp = 0 ;
        }
        if(totalCount==nonRotten) return minCount;
        return -1;
    }
}