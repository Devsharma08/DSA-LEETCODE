// with dijkstra's algorithm
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited = new boolean[n + 1];
        int[] wts = new int[n + 1];
        Arrays.fill(wts, Integer.MAX_VALUE);

        HashMap<Integer, ArrayList<int[]>> hash = new HashMap<>();

        for (int[] temp : times) {
            int key = temp[0];
            int num = temp[1];
            int wt = temp[2];
            hash.computeIfAbsent(key, x -> new ArrayList<>()).add(new int[] { num, wt });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { k, 0 });
        // k is the root node
        while (!pq.isEmpty()) {
            int[] temp1 = pq.poll();
            int node = temp1[0];
            int wt = temp1[1];

            if (wt > wts[node]) {
                continue;
            } else {
                wts[node] = wt;
            }

            for (int temp[] : hash.getOrDefault(node, new ArrayList<>())) {
                int ch = temp[0];
                int chw = temp[1];
                int twt = chw + wt;
                if (wts[ch] > twt) {
                    wts[ch] = twt;
                    pq.offer(new int[] { ch, twt });
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (wts[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, wts[i]);
        }
        return max;
    }
}