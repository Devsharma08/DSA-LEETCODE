import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_BITS = 20;

    // Maximum number of nodes:
    // root node + N * (MAX_BITS + 1)
    static int maxNodes;

    static int[] left;
    static int[] right;
    static int[] count;

    static int[] roots;

    static int nodes = 0;

    // Insert a value into the trie represented by previousRoot.
    // Returns the new root.
    static int insert(int previousRoot, int value) {
        int newRoot = ++nodes;

        left[newRoot] = left[previousRoot];
        right[newRoot] = right[previousRoot];
        count[newRoot] = count[previousRoot] + 1;

        int oldNode = previousRoot;
        int newNode = newRoot;

        for (int bit = MAX_BITS - 1; bit >= 0; bit--) {

            int valueBit = (value >> bit) & 1;

            if (valueBit == 0) {
                // Copy left child
                int oldChild = left[oldNode];

                int newChild = ++nodes;

                left[newChild] = left[oldChild];
                right[newChild] = right[oldChild];
                count[newChild] = count[oldChild] + 1;

                left[newNode] = newChild;

                oldNode = oldChild;
                newNode = newChild;

            } else {
                // Copy right child
                int oldChild = right[oldNode];

                int newChild = ++nodes;

                left[newChild] = left[oldChild];
                right[newChild] = right[oldChild];
                count[newChild] = count[oldChild] + 1;

                right[newNode] = newChild;

                oldNode = oldChild;
                newNode = newChild;
            }
        }

        return newRoot;
    }

    // Returns maximum value of (value XOR x)
    // among all values in positions [l, r].
    static int maxXor(int l, int r, int x) {

        int nodeR = roots[r];
        int nodeL = roots[l - 1];

        int answer = 0;

        for (int bit = MAX_BITS - 1; bit >= 0; bit--) {

            int xBit = (x >> bit) & 1;

            // To make XOR bit = 1, we want valueBit = opposite of xBit.
            int preferredR;
            int preferredL;

            if (xBit == 0) {
                preferredR = right[nodeR];
                preferredL = right[nodeL];
            } else {
                preferredR = left[nodeR];
                preferredL = left[nodeL];
            }

            // Number of values in the preferred branch
            // inside [l, r].
            int available = count[preferredR] - count[preferredL];

            if (available > 0) {
                // We can make this XOR bit 1.
                answer |= (1 << bit);

                nodeR = preferredR;
                nodeL = preferredL;
            } else {
                // Preferred branch doesn't exist in this range.
                // We must take the other branch.
                if (xBit == 0) {
                    nodeR = left[nodeR];
                    nodeL = left[nodeL];
                } else {
                    nodeR = right[nodeR];
                    nodeL = right[nodeL];
                }
            }
        }

        return answer;
    }

    public static List<Integer> maxXorQueries(
            int n,
            List<Integer> buoyCodes,
            List<int[]> queries
    ) {

        /*
         * Each inserted number creates:
         *
         * 1 root node + 20 bit nodes
         *
         * approximately 21 * N nodes.
         */
        maxNodes = n * (MAX_BITS + 1) + 5;

        left = new int[maxNodes];
        right = new int[maxNodes];
        count = new int[maxNodes];

        roots = new int[n + 1];

        /*
         * Node 0 is the empty trie.
         */
        roots[0] = 0;

        for (int i = 1; i <= n; i++) {
            int value = buoyCodes.get(i - 1);

            roots[i] = insert(roots[i - 1], value);
        }

        List<Integer> results = new ArrayList<>(queries.size());

        for (int[] query : queries) {

            int l = query[0];
            int r = query[1];
            int x = query[2];

            results.add(maxXor(l, r, x));
        }

        return results;
    }

    public static void main(String[] args) throws Exception {

        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();

        List<Integer> buoyCodes = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            buoyCodes.add(scanner.nextInt());
        }

        int q = scanner.nextInt();

        List<int[]> queries = new ArrayList<>(q);

        for (int i = 0; i < q; i++) {

            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();

            queries.add(new int[]{l, r, x});
        }

        List<Integer> results =
                maxXorQueries(n, buoyCodes, queries);

        StringBuilder output = new StringBuilder();

        for (int result : results) {
            output.append(result).append('\n');
        }

        System.out.print(output);
    }

    // Fast input
    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return result * sign;
        }
    }
}