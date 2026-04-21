class Solution {

    int index  = 0 ;

    public boolean hasCycle(int node,ArrayList<ArrayList<Integer>> list,boolean[] visited,boolean[] path, int[] result){
        if(path[node]) return true;
        if(visited[node]) return false ;
        

        path[node] = true;
        visited[node] = true;

        for(int temp:list.get(node)){
            if(hasCycle(temp,list,visited,path,result)) return true;
        }

        result[index--] = node;
        path[node] = false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0 ; numCourses > i ; i++) list.add(new ArrayList());

            for(int[] temp : prerequisites){
                // 0th index depends on 1st index
                list.get(temp[1]).add(temp[0]);
            }
        
        int[] result = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        index = numCourses-1;
        for(int i = 0 ; numCourses > i ; i++){
            if(hasCycle(i,list,visited,path,result)) return new int[0];
        }

        return result;
    }
}