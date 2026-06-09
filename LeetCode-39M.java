import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking at index 0 with a current sum of 0
        backtrack(0, 0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int ind, int currentSum, int[] candidates, int target, 
                            List<Integer> curr, List<List<Integer>> result) {
        // Base Case 1: If we match the target exactly, save the combination path
        if (currentSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Base Case 2: If we exceed the target or run out of candidate elements, stop exploring
        if (currentSum > target || ind == candidates.length) {
            return;
        }

        // Option 1: Choose to include the current candidate element
        curr.add(candidates[ind]);
        // Notice we stay at index 'ind' so the element can be reused on the next frame
        backtrack(ind, currentSum + candidates[ind], candidates, target, curr, result);
        curr.remove(curr.size() - 1); // Undo choice (Backtrack)

        // Option 2: Choose to completely skip the current candidate element and move forward
        backtrack(ind + 1, currentSum, candidates, target, curr, result);
    }
}