class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n != (edges.length+1)) return false;

        // making adjacency list - 1. cycle --- 2. any node remains left empty  
        HashSet<Integer> visited = new HashSet<>();

        // making an adjacency list using list
        List<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0 ; n > i ; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> st = new Stack<>();
        st.push(0);

        while(!st.isEmpty()){
            int temp = st.pop();
            visited.add(temp);

            for(int neighbour:list.get(temp)){
                if(!visited.contains(neighbour)){
                    st.push(neighbour);
                    visited.add(neighbour);
                }
                continue;
            }
        }

        if(visited.size()==n) return true;
        return false;
    }
}
