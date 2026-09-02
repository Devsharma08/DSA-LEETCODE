import java.util.*;

public class Main {

    public static List<Integer> computeHorizon(List<Integer> heights) {

        int n = heights.size();

        List<Integer> ans = new ArrayList<>(
            Collections.nCopies(n, 0)
        );

        // Stores indices of towers
        // Heights are maintained in decreasing order
        Deque<Integer> stack = new ArrayDeque<>();

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove towers that are not taller
            // Equal height does NOT count
            while (!stack.isEmpty()
                    && heights.get(stack.peek()) <= heights.get(i)) {

                stack.pop();
            }

            if (stack.isEmpty()) {

                // No taller tower exists
                ans.set(i, n - 1 - i);

            } else {

                // First taller tower
                int nextTaller = stack.peek();

                ans.set(i, nextTaller - i);
            }

            // Current tower becomes a candidate
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> heights = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            heights.add(scanner.nextInt());
        }

        List<Integer> horizonScores = computeHorizon(heights);

        for (int i = 0; i < horizonScores.size(); i++) {

            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print(horizonScores.get(i));
        }

        System.out.println();

        scanner.close();
    }
}