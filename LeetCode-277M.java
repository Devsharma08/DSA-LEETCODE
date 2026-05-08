/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            boolean isCelebrity = true;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                // Rule 1: Celebrity must not know anyone
                // Rule 2: Everyone must know the celebrity
                if (knows(i, j) || !knows(j, i)) {
                    isCelebrity = false;
                    break;
                }
            }
            
            if (isCelebrity) return i;
        }
        
        return -1;
    }
}