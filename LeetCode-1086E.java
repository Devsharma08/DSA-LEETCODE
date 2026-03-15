import java.util.*;

class Main {
    public static int[][] highFive(int[][] items) {
        
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            
            map.putIfAbsent(id, new PriorityQueue<>((a, b) -> b - a));
            map.get(id).offer(score);
        }

        List<int[]> result = new ArrayList<>();

        for (int id : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            
            for (int i = 0; i < 5; i++) {
                sum += pq.poll();
            }
            result.add(new int[]{id, sum / 5});
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] marks = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] res = highFive(marks);
        for(int[] row : res) System.out.println(Arrays.toString(row));
    }
}