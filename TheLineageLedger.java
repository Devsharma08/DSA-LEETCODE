import java.util.*;

public class Main {

    static void userLogic(
            int n,
            List<int[]> rulerInfo,
            int q,
            List<int[]> queries,
            List<int[]> results) {

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : rulerInfo) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        for (int[] query : queries) {

            int start = query[0];
            int end = query[1];

            boolean[] visited = new boolean[n + 1];

            // [node, distance, nodeCount]
            int[] result = dfs(
                    start,
                    end,
                    graph,
                    visited
            );

            results.add(new int[]{
                    result[0],
                    result[1]
            });
        }
    }

    static int[] dfs(
            int current,
            int target,
            List<List<int[]>> graph,
            boolean[] visited) {

        if (current == target) {
            return new int[]{0, 1};
        }

        visited[current] = true;

        for (int[] edge : graph.get(current)) {

            int next = edge[0];
            int weight = edge[1];

            if (visited[next]) {
                continue;
            }

            int[] result = dfs(
                    next,
                    target,
                    graph,
                    visited
            );

            // Target found
            if (result != null) {

                int distance = weight + result[0];
                int nodeCount = 1 + result[1];

                return new int[]{
                        distance,
                        nodeCount
                };
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<int[]> rulerInfo = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {

            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            rulerInfo.add(new int[]{u, v, w});
        }

        int q = scanner.nextInt();

        List<int[]> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            queries.add(new int[]{x, y});
        }

        List<int[]> results = new ArrayList<>();

        userLogic(
                n,
                rulerInfo,
                q,
                queries,
                results
        );

        for (int[] result : results) {
            System.out.println(result[0] + " " + result[1]);
        }
    }
}