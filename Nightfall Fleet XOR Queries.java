import java.io.*;

class Main {
    private static final int MAX_BIT = 30;

    private static final class FastScanner {
        private final InputStream input = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer;
        private int length;

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

        int nextInt() throws IOException {
            int character;
            do {
                character = read();
            } while (character <= ' ');

            int value = 0;
            while (character > ' ') {
                value = value * 10 + character - '0';
                character = read();
            }
            return value;
        }
    }

    private static final class PersistentTrie {
        private final int[] left;
        private final int[] right;
        private final int[] count;
        private int size;

        PersistentTrie(int capacity) {
            left = new int[capacity];
            right = new int[capacity];
            count = new int[capacity];
        }

        int insert(int previousRoot, int value) {
            int newRoot = copy(previousRoot);
            int current = newRoot;
            int previous = previousRoot;
            count[current]++;

            for (int bit = MAX_BIT; bit >= 0; bit--) {
                boolean set = (value & (1 << bit)) != 0;
                int previousChild = set ? right[previous] : left[previous];
                int newChild = copy(previousChild);
                count[newChild]++;

                if (set) {
                    right[current] = newChild;
                } else {
                    left[current] = newChild;
                }
                current = newChild;
                previous = previousChild;
            }
            return newRoot;
        }

        int maximumXor(int rightRoot, int leftRoot, int value) {
            int answer = 0;
            int currentRight = rightRoot;
            int currentLeft = leftRoot;

            for (int bit = MAX_BIT; bit >= 0; bit--) {
                boolean set = (value & (1 << bit)) != 0;
                int preferredRight = set ? left[currentRight] : right[currentRight];
                int preferredLeft = set ? left[currentLeft] : right[currentLeft];

                if (count(preferredRight, preferredLeft) > 0) {
                    answer |= 1 << bit;
                    currentRight = preferredRight;
                    currentLeft = preferredLeft;
                } else {
                    currentRight = set ? right[currentRight] : left[currentRight];
                    currentLeft = set ? right[currentLeft] : left[currentLeft];
                }
            }
            return answer;
        }

        private int count(int rightNode, int leftNode) {
            return count[rightNode] - count[leftNode];
        }

        private int copy(int node) {
            int copied = ++size;
            left[copied] = left[node];
            right[copied] = right[node];
            count[copied] = count[node];
            return copied;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] codes = new int[n];
        for (int index = 0; index < n; index++) {
            codes[index] = scanner.nextInt();
        }

        PersistentTrie trie = new PersistentTrie((n + 1) * (MAX_BIT + 2));
        int[] roots = new int[n + 1];
        for (int index = 1; index <= n; index++) {
            roots[index] = trie.insert(roots[index - 1], codes[index - 1]);
        }

        int queryCount = scanner.nextInt();
        StringBuilder output = new StringBuilder();
        for (int query = 0; query < queryCount; query++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            int value = scanner.nextInt();
            output.append(trie.maximumXor(roots[right], roots[left - 1], value)).append('\n');
        }
        System.out.print(output);
    }
}
