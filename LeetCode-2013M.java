import java.util.HashMap;
import java.util.Map;

class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> hash;

    public DetectSquares() {
        hash = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        Map<Integer, Integer> yMap = hash.computeIfAbsent(x, k -> new HashMap<>());
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        if (!hash.containsKey(x1)) {
            return 0;
        }

        int totalSquares = 0;
        Map<Integer, Integer> currentXMap = hash.get(x1);

        for (Map.Entry<Integer, Map<Integer, Integer>> entry : hash.entrySet()) {
            int x2 = entry.getKey();
            if (x2 == x1) continue;

            Map<Integer, Integer> otherXMap = entry.getValue();
            int sideLength = x2 - x1;
        }
        
        for (Map.Entry<Integer, Integer> entry : currentXMap.entrySet()) {
            int y2 = entry.getKey();
            int countY2 = entry.getValue();

            if (y2 == y1) continue;

            int sideLength = Math.abs(y2 - y1);
            
            int xLeft = x1 - sideLength;
            totalSquares += countY2 * 
                            hash.getOrDefault(xLeft, new HashMap<>()).getOrDefault(y1, 0) * 
                            hash.getOrDefault(xLeft, new HashMap<>()).getOrDefault(y2, 0);

            int xRight = x1 + sideLength;
            totalSquares += countY2 * 
                            hash.getOrDefault(xRight, new HashMap<>()).getOrDefault(y1, 0) * 
                            hash.getOrDefault(xRight, new HashMap<>()).getOrDefault(y2, 0);
        }

        return totalSquares;
    }
}   