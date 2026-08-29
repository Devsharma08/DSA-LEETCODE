import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LanternFestivalFinale {

    public static long maxBalancedGlow(int n, long L, long[] glowIntensities) {

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        long windowSum = 0;
        long answer = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (!minDeque.isEmpty()
                    && glowIntensities[minDeque.peekLast()] >= glowIntensities[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while (!maxDeque.isEmpty()
                    && glowIntensities[maxDeque.peekLast()] <= glowIntensities[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            windowSum += glowIntensities[right];

            while (glowIntensities[maxDeque.peekFirst()]
                    - glowIntensities[minDeque.peekFirst()] > L) {

                windowSum -= glowIntensities[left];

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                left++;
            }

            answer = Math.max(answer, windowSum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long L = scanner.nextLong();

        long[] glowIntensities = new long[n];

        for (int i = 0; i < n; i++) {
            glowIntensities[i] = scanner.nextLong();
        }

        long result = maxBalancedGlow(n, L, glowIntensities);
        System.out.println(result);

        scanner.close();
    }
}
