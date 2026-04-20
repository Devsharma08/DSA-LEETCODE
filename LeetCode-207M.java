class Solution {

// for values type numbers list would be better suited and for string hash is the only option
    public boolean hasCircle(int node, ArrayList<ArrayList<Integer>> list,boolean[] visited,boolean[] path){
        if(path[node] == true) return true;
        if(visited[node] == true) return false;
        visited[node] = true;
        path[node] = true;

        for(int temp : list.get(node)){
            if(hasCircle(temp,list,visited,path)) return true;
        }
        
        path[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0 ; numCourses > i ; i++){
            list.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0 ; numCourses > i ; i++ ){
            if(hasCircle(i,list,visited,path)) return false;
        }
        return true;
    }
}