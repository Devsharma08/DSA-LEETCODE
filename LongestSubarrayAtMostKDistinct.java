/**
 * Problem: Longest Subarray with at Most K Distinct Values
 *
 * Meera manages restoration records at the Kolkata Heritage Library. The
 * books are stored in order on one long shelf. Each book has an integer
 * fragrance code based on the preservation chemical used on it.
 *
 * A continuous reading corner may contain at most K distinct fragrance codes.
 * Given the fragrance code of every book and K, find the length of the longest
 * continuous stretch of shelf that satisfies this condition.
 *
 * Input:
 * - Line 1: two integers N and K.
 * - Line 2: N integers containing the fragrance code of each book.
 *
 * Output:
 * Print the length of the longest continuous stretch containing at most K
 * distinct fragrance codes.
 *
 * Constraints:
 * - 1 <= N <= 200000
 * - 1 <= K <= N
 * - 1 <= fragrance code <= 10^9
 *
 * Sample 0:
 * Input:  6 1 / 2 2 2 3 3 2
 * Output: 3
 *
 * Sample 1:
 * Input:  8 2 / 4 4 7 7 7 9 4 4
 * Output: 5
 *
 * Approach: Use a sliding window with two pointers and a frequency map. Each
 * boundary moves at most N times, giving O(N) time and O(K) extra space.
 */
import java.io.*;
import java.util.*;

public class LongestSubarrayAtMostKDistinct {

    static int longestSubarrayAtMostKDistinct(long[] arr, int n, int k) {
        Map<Long, Integer> frequencies = new HashMap<>();
        int left = 0;
        int maximumLength = 0;

        for (int right = 0; right < n; right++) {
            frequencies.put(arr[right], frequencies.getOrDefault(arr[right], 0) + 1);

            while (frequencies.size() > k) {
                long leftValue = arr[left++];
                int remaining = frequencies.get(leftValue) - 1;

                if (remaining == 0) {
                    frequencies.remove(leftValue);
                } else {
                    frequencies.put(leftValue, remaining);
                }
            }

            maximumLength = Math.max(maximumLength, right - left + 1);
        }

        return maximumLength;
    }

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        System.out.println(longestSubarrayAtMostKDistinct(arr, n, k));
    }

    private static class FastScanner {
        private final InputStream input;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer;
        private int length;

        FastScanner(InputStream input) {
            this.input = input;
        }

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

        long nextLong() throws IOException {
            int character;
            do {
                character = read();
            } while (character <= ' ' && character != -1);

            boolean negative = character == '-';
            if (negative) {
                character = read();
            }

            long value = 0;
            while (character > ' ') {
                value = value * 10 + character - '0';
                character = read();
            }
            return negative ? -value : value;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
