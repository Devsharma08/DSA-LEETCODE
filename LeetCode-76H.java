class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] mapT = new int[128];
        for (char c : t.toCharArray()) {
            mapT[c]++;
        }

        int countT = t.length(); 
        int minLen = Integer.MAX_VALUE;
        int start = 0; 
        int left = 0;
        
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (mapT[c] > 0) {
                countT--;
            }
        
            mapT[c]--;

            while (countT == 0) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                mapT[leftChar]++;
                if (mapT[leftChar] > 0) {
                    countT++;
                }
                
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}