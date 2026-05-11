class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[k] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dists[u]) continue;

            if (adj.containsKey(u)) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                 
                    if (dists[u] + weight < dists[v]) {
                        dists[v] = dists[u] + weight;
                        pq.add(new int[]{v, dists[v]});
                    }
                }
            }
        }
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dists[i] == Integer.MAX_VALUE) return -1;
            maxDelay = Math.max(maxDelay, dists[i]);
        }

        return maxDelay;
    }
}