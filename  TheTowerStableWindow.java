import java.util.*;

public class Main {

    public static int[] longestStretch(int n, long D, int[] arr) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int left = 0;

        int bestLength = 0;
        int bestStart = 1;

        for (int right = 0; right < n; right++) {

            int value = arr[right];

            // Add value to the window
            map.put(value, map.getOrDefault(value, 0) + 1);

            // Shrink until the window is valid
            while (true) {

                int min = map.firstKey();
                int max = map.lastKey();

                boolean duplicate = false;

                // If any value has frequency > 1
                if (map.get(arr[right]) > 1) {
                    duplicate = true;
                }

                boolean rangeInvalid = ((long) max - min > D);

                if (!duplicate && !rangeInvalid) {
                    break;
                }

                // Remove arr[left]
                int remove = arr[left];

                int count = map.get(remove);

                if (count == 1) {
                    map.remove(remove);
                } else {
                    map.put(remove, count - 1);
                }

                left++;
            }

            int length = right - left + 1;

            if (length > bestLength) {
                bestLength = length;
                bestStart = left + 1;
            }
        }

        return new int[]{bestLength, bestStart};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long D = sc.nextLong();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = longestStretch(n, D, arr);

        System.out.println(result[0] + " " + result[1]);
    }
}