import java.io.*;
import java.util.*;

class Main {

    private static final class FastScanner {
        private final InputStream input = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer;
        private int length;

        private int read() throws IOException {
            if (pointer >= length) {
                length = input.read(buffer);
                pointer = 0;
                if (length <= 0) {
                    return -1;
                }
            }
            return buffer[pointer++];
        }

        int nextInt() throws IOException {
            int character;
            do {
                character = read();
            } while (character <= ' ');

            int sign = 1;
            if (character == '-') {
                sign = -1;
                character = read();
            }

            int value = 0;
            while (character > ' ') {
                value = value * 10 + character - '0';
                character = read();
            }
            return value * sign;
        }
    }

    private static final class Edge {
        final int to;
        final int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static long[] calculateResonance(int[] values, List<Edge>[] graph) {
        int n = values.length;
        int[] parent = new int[n];
        int[] parentWeight = new int[n];
        int[] order = new int[n];
        long[] distance = new long[n];
        Arrays.fill(parent, -2);
        parent[0] = -1;

        int orderSize = 1;
        order[0] = 0;
        long rootAnswer = 0;

        for (int index = 0; index < orderSize; index++) {
            int node = order[index];
            rootAnswer += (long) values[node] * distance[node];

            for (Edge edge : graph[node]) {
                if (edge.to == parent[node]) {
                    continue;
                }
                parent[edge.to] = node;
                parentWeight[edge.to] = edge.weight;
                distance[edge.to] = distance[node] + edge.weight;
                order[orderSize++] = edge.to;
            }
        }

        long totalValue = 0;
        long[] subtreeValue = new long[n];
        for (int node = 0; node < n; node++) {
            totalValue += values[node];
            subtreeValue[node] = values[node];
        }

        for (int index = n - 1; index > 0; index--) {
            int node = order[index];
            subtreeValue[parent[node]] += subtreeValue[node];
        }

        long[] answer = new long[n];
        answer[0] = rootAnswer;
        for (int index = 1; index < n; index++) {
            int node = order[index];
            int parentNode = parent[node];
            answer[node] = answer[parentNode]
                    + (long) parentWeight[node]
                    * (totalValue - 2L * subtreeValue[node]);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] values = new int[n];

        for (int node = 0; node < n; node++) {
            values[node] = scanner.nextInt();
        }

        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[n];
        for (int node = 0; node < n; node++) {
            graph[node] = new ArrayList<>();
        }

        for (int edge = 0; edge < n - 1; edge++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }

        long[] answer = calculateResonance(values, graph);
        StringBuilder output = new StringBuilder();
        for (long value : answer) {
            if (output.length() > 0) {
                output.append(' ');
            }
            output.append(value);
        }
        System.out.println(output);
    }
}
