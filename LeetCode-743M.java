class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> hash = new HashMap<>();
        for (int[] temp : times) {
            hash.computeIfAbsent(temp[0], e -> new ArrayList<>()).add(new int[] { temp[1], temp[2] });
        }

        int[] weight = new int[n + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);

        weight[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // add node and it's weight
        pq.offer(new int[] { k, 0 });

        while (!pq.isEmpty()) {
            int[] temp = pq.remove();
            int node = temp[0];
            int nodeWeight = temp[1];

            if(weight[node] < nodeWeight) continue;

            if (weight[node] > nodeWeight) {
                weight[node] = nodeWeight;
            }
            if (hash.containsKey(node)) {
                for (int i = 0; hash.get(node).size() > i; i++) {
                    int[] in = hash.get(node).get(i);
                    int a = in[0];
                    int b = in[1];

                    if (weight[a] > nodeWeight + b) {
                        weight[a] = nodeWeight + b;
                        pq.offer(new int[]{a,weight[a]});
                    }
                }
            }
        }

        int max = -1;
        for (int i = 1; n + 1 > i; i++) {
            if (weight[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(weight[i], max);
        }
        return max;

    }
}