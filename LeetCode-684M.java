// solved using disjoint set union
class Solution {

//     public int find(int[] parent, int v) {
//     if (parent[v] != v)
//         parent[v] = find(parent, parent[v]);
//     return parent[v];
//     }


    public int find(int[] parent,int node){
        while(parent[node]!=node){
            parent[node] = parent[parent[node]]; // 1 step forward
            node = parent[node]; // 2 steps forward
        }
        return node;
    }
    public int[] findRedundantConnection(int[][] edges) {
        // making an parent array - nodes starting from 1 to n so len + 1
        int[] parent = new int[edges.length + 1];

        // now seeding parent arr with their own node value
        for(int i = 1 ; parent.length > i ; i++){
            parent[i] = i ;
        }

        // now iterating through edges for finding parents of each node and compare then if found common immediate return else continue until all parsed
        for(int[] edge:edges){
            int parent1 = find(parent,edge[0]);
            int parent2 = find(parent,edge[1]);

            if(parent1==parent2){
                return edge;
            } else{
                // if not found then 0th index becomes parent of other node
                parent[parent2] = parent1;
            } 
        }
        // if not found return null
        return new int[]{};
    }
}