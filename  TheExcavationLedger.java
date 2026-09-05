import java.util.*;

public class Main {

    public static long countDivisibleSegments(int[] arr, int n, int k) {

        long total = 0;
        Map<Integer, Long> freq = new HashMap<>();
        freq.put(0, 1L);
        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            int remainder = (int)(prefixSum % k);
            if (remainder < 0) {
                remainder += k;
            }
            long previous = freq.getOrDefault(remainder, 0L);
            total += previous;
            freq.put(remainder, previous + 1);
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(countDivisibleSegments(arr, n, k));
    }
}