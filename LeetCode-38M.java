class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1"; // Base case: n = 1

        // Perform the "Count and Say" process n-1 times
        while (n > 1) {
            StringBuilder cur = new StringBuilder();
            
            // Iterate through the current result string
            for (int i = 0; i < res.length(); i++) {
                int count = 1;
                
                // Count how many consecutive characters are the same
                while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {
                    count++;
                    i++;
                }
                
                // Say it: "count" + "character"
                cur.append(count).append(res.charAt(i));
            }
            
            res = cur.toString(); // Update for next iteration
            n--;
        }
        
        return res;
    }
}