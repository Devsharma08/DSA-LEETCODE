class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] wts = new int[n];
        Arrays.fill(wts, Integer.MAX_VALUE);
        wts[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tempWts = Arrays.copyOf(wts, n);

            for (int[] flight : flights) {
                int u = flight[0];   // Source city
                int v = flight[1];   // Destination city
                int price = flight[2]; // Ticket cost

                if (wts[u] != Integer.MAX_VALUE) {
                    if (wts[u] + price < tempWts[v]) {
                        tempWts[v] = wts[u] + price;
                    }
                }
            }
            // swap the temporary updates back into our main weights array
            wts = tempWts;
        }

        return wts[dst] == Integer.MAX_VALUE ? -1 : wts[dst];
    }
}