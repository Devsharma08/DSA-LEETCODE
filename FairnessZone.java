import java.util.*;

public class FairnessZone {

    static int longestFairSegment(long[] prices, int n, long d) {
        if (n == 0) return 0;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;
        int answer = 0;

        for (int right = 0; right < n; right++) {

            // Maintain increasing order -> front is minimum
            while (!minDeque.isEmpty()
                    && prices[minDeque.peekLast()] >= prices[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // Maintain decreasing order -> front is maximum
            while (!maxDeque.isEmpty()
                    && prices[maxDeque.peekLast()] <= prices[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // Current window is invalid
            while (prices[maxDeque.peekFirst()]
                    - prices[minDeque.peekFirst()] > d) {

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                left++;
            }

            // Current window [left, right] is valid
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long d = scanner.nextLong();

        long[] prices = new long[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextLong();
        }

        System.out.println(longestFairSegment(prices, n, d));
    }
}
