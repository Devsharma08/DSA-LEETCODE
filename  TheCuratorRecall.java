import java.util.*;

public class Main {

    static void countDistinctArtists(
            int n,
            List<Integer> artistIds,
            int q,
            List<int[]> stretches,
            List<Integer> results) {

        // Convert artist IDs to an array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = artistIds.get(i);
        }

        // Query: l, r, index
        int[][] queries = new int[q][3];

        for (int i = 0; i < q; i++) {
            queries[i][0] = stretches.get(i)[0] - 1; // 0-indexed
            queries[i][1] = stretches.get(i)[1] - 1;
            queries[i][2] = i;
        }

        // Coordinate compression because artist ID can be up to 1e9
        Map<Integer, Integer> compressed = new HashMap<>();

        int id = 0;

        for (int value : arr) {
            if (!compressed.containsKey(value)) {
                compressed.put(value, id++);
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = compressed.get(arr[i]);
        }

        // Mo's block size
        int blockSize = (int) Math.sqrt(n) + 1;

        // Sort queries using Mo's ordering
        Arrays.sort(queries, (a, b) -> {
            int blockA = a[0] / blockSize;
            int blockB = b[0] / blockSize;

            if (blockA != blockB) {
                return Integer.compare(blockA, blockB);
            }

            // Alternating direction improves performance
            if ((blockA & 1) == 0) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });

        int[] frequency = new int[id];

        int currentLeft = 0;
        int currentRight = -1;
        int distinct = 0;

        int[] answer = new int[q];

        for (int[] query : queries) {

            int left = query[0];
            int right = query[1];
            int queryIndex = query[2];

            // Expand left
            while (currentLeft > left) {
                currentLeft--;

                int value = arr[currentLeft];

                if (frequency[value] == 0) {
                    distinct++;
                }

                frequency[value]++;
            }

            // Expand right
            while (currentRight < right) {
                currentRight++;

                int value = arr[currentRight];

                if (frequency[value] == 0) {
                    distinct++;
                }

                frequency[value]++;
            }

            // Shrink left
            while (currentLeft < left) {
                int value = arr[currentLeft];

                frequency[value]--;

                if (frequency[value] == 0) {
                    distinct--;
                }

                currentLeft++;
            }

            // Shrink right
            while (currentRight > right) {
                int value = arr[currentRight];

                frequency[value]--;

                if (frequency[value] == 0) {
                    distinct--;
                }

                currentRight--;
            }

            answer[queryIndex] = distinct;
        }

        // Preserve original query order
        for (int i = 0; i < q; i++) {
            results.add(answer[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> artistIds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            artistIds.add(scanner.nextInt());
        }

        int q = scanner.nextInt();

        List<int[]> stretches = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            stretches.add(new int[]{l, r});
        }

        List<Integer> results = new ArrayList<>();

        countDistinctArtists(
                n,
                artistIds,
                q,
                stretches,
                results
        );

        for (int result : results) {
            System.out.println(result);
        }
    }
}