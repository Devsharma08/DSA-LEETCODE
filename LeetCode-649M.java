import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        for (char c : senate.toCharArray()) q.offer(c);

        int rBans = 0; // Number of Radiant senators to be banned
        int dBans = 0; // Number of Dire senators to be banned
        
        // Keep going as long as both parties have members
        // We need a way to count how many of each are left
        while (true) {
            int rCount = 0;
            int dCount = 0;
            int currentSize = q.size();
            
            for (int i = 0; i < currentSize; i++) {
                char curr = q.poll();
                if (curr == 'R') {
                    if (rBans > 0) {
                        rBans--; // This senator is now banned
                    } else {
                        dBans++; // This senator bans a Dire member
                        q.offer('R'); // Moves to the back of the line
                        rCount++;
                    }
                } else { // It's a 'D'
                    if (dBans > 0) {
                        dBans--; // This senator is now banned
                    } else {
                        rBans++; // This senator bans a Radiant member
                        q.offer('D'); // Moves to the back of the line
                        dCount++;
                    }
                }
            }
            
            // If one party is completely gone, the other wins
            if (rCount == 0) return "Dire";
            if (dCount == 0) return "Radiant";
        }
    }
}