import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        int remStart = toBeRemoved[0];
        int remEnd = toBeRemoved[1];
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (end <= remStart || start >= remEnd) {
                result.add(List.of(start, end));
            } else {
                if (start < remStart) {
                    result.add(List.of(start, remStart));
                }
                if (end > remEnd) {
                    result.add(List.of(remEnd, end));
                }
            }
        }
        
        return result;
    }
}