class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] list = new int[128]; 
        
        int left = 0;
        int ans = 0; 
        
        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // Increment count
            list[currentChar]++;
            
    
            while(list[currentChar] > 1) {
                char leftChar = s.charAt(left);
                list[leftChar]--;
                left++;
            } 
            
            ans = Math.max(ans, right - left + 1);
        } 
        return ans;
    }
}