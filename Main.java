import java.util.*;

public class Main {

    public static int userLogic(int[] readings, int n, long limit) {

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {

            // Maintain increasing deque for minimum
            while (!minDeque.isEmpty()
                    && readings[minDeque.peekLast()] >= readings[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Maintain decreasing deque for maximum
            while (!maxDeque.isEmpty()
                    && readings[maxDeque.peekLast()] <= readings[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Shrink window if max - min > limit
            while ((long) readings[maxDeque.peekFirst()]
                    - readings[minDeque.peekFirst()] > limit) {

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                left++;
            }

            // Current window is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long limit = scanner.nextLong();

        int[] readings = new int[n];

        for (int i = 0; i < n; i++) {
            readings[i] = scanner.nextInt();
        }

        System.out.println(userLogic(readings, n, limit));

        scanner.close();
    }
}
