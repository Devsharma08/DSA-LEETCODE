import java.io.*;
import java.util.*;

public class Main {
    static class Line {
        long m, c;

        Line(long m, long c) {
            this.m = m;
            this.c = c;
        }

        long eval(long x) {
            return m * x + c;
        }

        double intersect(Line other) {
            return (double) (other.c - this.c) / (this.m - other.m);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        
        if (!sc.hasNext()) return;

        int n = sc.nextInt();
        long w = sc.nextLong();

        long[] energy = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            energy[i] = sc.nextLong();
        }

        long[] dp = new long[n + 1];
        dp[1] = energy[1];
        Deque<Line> deque = new ArrayDeque<>();
        deque.addLast(new Line(-2 * w * 1, dp[1] + w * 1 * 1));

        for (int i = 2; i <= n; i++) {
            long x = i;
            while (deque.size() >= 2) {
                Line l1 = deque.pollFirst();
                Line l2 = deque.peekFirst();

                if (l1.eval(x) >= l2.eval(x)) {
                    continue;
                } else {
                    deque.addFirst(l1);
                    break;
                }
            }
            long minPrev = deque.peekFirst().eval(x);
            dp[i] = energy[i] + w * i * i + minPrev;

            Line newLine = new Line(-2 * w * i, dp[i] + w * (long) i * i);
            while (deque.size() >= 2) {
                Line l2 = deque.pollLast();
                Line l1 = deque.peekLast();

                if (newLine.intersect(l1) <= l2.intersect(l1)) {
                    continue;
                } else {
                    deque.addLast(l2);
                    break;
                }
            }

            deque.addLast(newLine);
        }

        System.out.println(dp[n]);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean hasNext() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return false;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }

        String next() {
            return hasNext() ? st.nextToken() : null;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}