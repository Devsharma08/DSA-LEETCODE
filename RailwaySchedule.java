import java.io.*;
import java.util.*;

public class RailwaySchedule {

    static class Edge {
        int to;
        long first;
        long freq;
        long dur;

        Edge(int to, long first, long freq, long dur) {
            this.to = to;
            this.first = first;
            this.freq = freq;
            this.dur = dur;
        }
    }

    static class State implements Comparable<State> {
        int node;
        long time;

        State(int node, long time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.time, other.time);
        }
    }

    static long earliestDeparture(long current, Edge e) {
        if (e.freq == 0) {
            return e.first >= current ? e.first : -1;
        }

        if (current <= e.first) {
            return e.first;
        }

        long diff = current - e.first;
        long k = diff / e.freq;

        if (diff % e.freq != 0) {
            k++;
        }

        return e.first + k * e.freq;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long first = Long.parseLong(st.nextToken());
            long freq = Long.parseLong(st.nextToken());
            long dur = Long.parseLong(st.nextToken());

            graph[u].add(new Edge(v, first, freq, dur));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(S, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            long currentTime = cur.time;

            if (currentTime != dist[u]) {
                continue;
            }

            if (u == D) {
                System.out.println(currentTime);
                return;
            }

            for (Edge e : graph[u]) {
                long departure = earliestDeparture(currentTime, e);
                if (departure == -1) {
                    continue;
                }

                long arrival = departure + e.dur;
                if (arrival < dist[e.to]) {
                    dist[e.to] = arrival;
                    pq.offer(new State(e.to, arrival));
                }
            }
        }

        System.out.println(-1);
    }
}
