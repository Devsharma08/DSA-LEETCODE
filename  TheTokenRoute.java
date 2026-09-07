import java.util.*;

public class Main {

    public static long minTokenRoute(
            int n, int m, int k,
            int src, int dst,
            int[][] roads) {

        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adjList.get(u).add(new int[]{v, w});
        }

        long[][] dist = new long[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[1], b[1])
        );

        dist[src][0] = 0;
        pq.offer(new long[]{src, 0, 0});

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            int node = (int) current[0];
            long cost = current[1];
            int tokensUsed = (int) current[2];

            if (cost != dist[node][tokensUsed]) {
                continue;
            }

            if (node == dst) {
                return cost;
            }

            for (int[] edge : adjList.get(node)) {

                int next = edge[0];
                int roadCost = edge[1];
                long newCost = cost + roadCost;

                if (newCost < dist[next][tokensUsed]) {

                    dist[next][tokensUsed] = newCost;

                    pq.offer(new long[]{
                            next,
                            newCost,
                            tokensUsed
                    });
                }

                if (tokensUsed < k) {

                    // Road becomes free
                    newCost = cost;

                    if (newCost < dist[next][tokensUsed + 1]) {

                        dist[next][tokensUsed + 1] = newCost;

                        pq.offer(new long[]{
                                next,
                                newCost,
                                tokensUsed + 1
                        });
                    }
                }
            }
        }

        // Destination cannot be reached
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int src = sc.nextInt();
        int dst = sc.nextInt();

        int[][] roads = new int[m][3];

        for (int i = 0; i < m; i++) {
            roads[i][0] = sc.nextInt();
            roads[i][1] = sc.nextInt();
            roads[i][2] = sc.nextInt();
        }

        long result = minTokenRoute(
                n, m, k, src, dst, roads
        );

        System.out.println(result);
    }
}