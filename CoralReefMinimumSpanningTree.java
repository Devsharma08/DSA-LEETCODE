/**
 * Coral Reef Sensor Network - Minimum Spanning Tree Problem
 * 
 * PROBLEM STATEMENT:
 * Dev leads an underwater research team building a permanent sensor network across a coral reef.
 * The team has surveyed n research pods scattered across the seabed and identified m possible 
 * cable routes between certain pairs of pods, each with a fixed installation cost.
 * 
 * Every pod eventually needs to be part of one connected network. The goal is to find the minimum
 * total cost to connect all pods such that every pod is reachable from every other pod through
 * some sequence of cables. Some routes may be far more expensive than others due to terrain and 
 * cable requirements.
 * 
 * If full connectivity is impossible (some pods cannot be reached), return -1.
 * 
 * INPUT FORMAT:
 * - First line: two integers n and m
 * - Next m lines: three integers u, v, w (cable route between pod u and v with cost w)
 * 
 * OUTPUT FORMAT:
 * A single integer - the minimum total cost to connect all pods, or -1 if impossible.
 * 
 * CONSTRAINTS:
 * - 1 ≤ n ≤ 10^5
 * - 0 ≤ m ≤ 2×10^5
 * - 1 ≤ u, v ≤ n
 * - 1 ≤ w ≤ 10^9
 * 
 * SAMPLE TESTCASE 0:
 * Input:
 *   4 5
 *   1 2 1
 *   2 3 2
 *   3 4 3
 *   1 3 4
 *   1 4 5
 * 
 * Output: 6
 * 
 * Explanation:
 * - Sorting routes by cost: (1-2,1), (2-3,2), (3-4,3), (1-3,4), (1-4,5)
 * - Add (1-2,1): pods 1 and 2 join — cost 1
 * - Add (2-3,2): pod 3 joins — cost 3
 * - Add (3-4,3): pod 4 joins — cost 6. All 4 pods connected with 3 cables.
 * - Routes (1-3,4) and (1-4,5) are skipped as they would create cycles.
 * - Minimum total cost is 6.
 * 
 * SAMPLE TESTCASE 1:
 * Input:
 *   4 2
 *   1 2 5
 *   3 4 7
 * 
 * Output: -1
 * 
 * Explanation:
 * - Routes only connect {1,2} and {3,4} into separate groups
 * - No route links the two groups, so full connectivity is impossible
 * 
 * SOLUTION: Kruskal's Algorithm with Union-Find
 * Time Complexity: O(m log m) for sorting + O(m × α(n)) for union-find = O(m log m)
 * Space Complexity: O(n + m)
 */

import java.util.*;

class Edge {
    int u, v;
    long w;

    Edge(int u, int v, long w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class CoralReefMinimumSpanningTree {

    static int[] parent;
    static int[] rank;

    /**
     * Find the representative (root) of a node using path compression
     */
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * Connect two components using union by rank
     * Returns true if the union was successful (components were different)
     * Returns false if they're already in the same component (would create a cycle)
     */
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // Already connected -> adding this edge creates a cycle
        if (rootA == rootB) {
            return false;
        }

        // Union by rank - attach smaller tree under larger tree
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } 
        else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } 
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }

    /**
     * Find minimum cost to connect all n pods using at most m cable routes
     * Uses Kruskal's algorithm: sort edges by cost, greedily add edges that don't create cycles
     */
    public static long minRelayCost(int n, int m, List<Edge> edges) {

        // A single pod is already connected
        if (n == 1) {
            return 0;
        }

        // Sort edges by cost (cheapest first)
        edges.sort(Comparator.comparingLong(e -> e.w));

        // Initialize Union-Find data structure
        parent = new int[n + 1];
        rank = new int[n + 1];

        // Initially every pod is its own component
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        long totalCost = 0;
        int edgesUsed = 0;

        // Process edges in order of increasing cost
        for (Edge edge : edges) {

            // Only add edge if it connects two previously separate components
            if (union(edge.u, edge.v)) {

                totalCost += edge.w;
                edgesUsed++;

                // A spanning tree with n nodes has exactly n - 1 edges
                if (edgesUsed == n - 1) {
                    return totalCost;
                }
            }
        }

        // Not all pods could be connected (graph is disconnected)
        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int u = scanner.nextInt();
            int v = scanner.nextInt();
            long w = scanner.nextLong();

            edges.add(new Edge(u, v, w));
        }

        long result = minRelayCost(n, m, edges);

        System.out.println(result);

        scanner.close();
    }
}
