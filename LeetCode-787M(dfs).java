// using Dijkstra's algorithm with a priority queue to find the cheapest price from src to dst with at most k stops

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<int[]>> hash = new HashMap<>();
        for (int[] temp : flights) {
            hash.computeIfAbsent(temp[0], x -> new ArrayList<int[]>()).add(new int[] { temp[1], temp[2] });
        }
        int[] weights = new int[n];
        Arrays.fill(weights, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);

        queue.offer(new int[]{src,0,0});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int curr = temp[0];
            int cost = temp[1];
            int stops = temp[2];

            if(curr==dst) return cost;
            if(stops > k) continue;

            // if reach the city with fewer or equal nodes - unless it's cheaper but we're using pq which gives the shortest path first 
            if(weights[curr] <= stops) continue;
            weights[curr] = stops;

            if(hash.containsKey(curr)){
                for(int[] t : hash.get(curr)){
                    queue.offer(new int[]{t[0],cost+t[1],stops+1});
                }
            }


        }
        return -1;
    }
}