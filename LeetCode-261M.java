class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (hasCycle(adj, 0, visited, -1)) return false;
        return visited.size() == n;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> adj, int node, Set<Integer> visited, int parent) {
        visited.add(node);
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;
            if (visited.contains(neighbor) || hasCycle(adj, neighbor, visited, node)) 
                return true;
        }
        return false;
    }
}   