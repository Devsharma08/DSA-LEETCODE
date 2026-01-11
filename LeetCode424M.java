class Solution {
    public int characterReplacement(String s, int k) {
        int[] list = new int[26];
        int maxOccuring = 0;
        int sLength = s.length();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < sLength; right++) {
            
            maxOccuring = Math.max(maxOccuring, ++list[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxOccuring > k) {
                --list[s.charAt(left) - 'A'];
                left++;
            }

            ans = Math.max(ans, (right - left + 1));
        }
        return ans;
    }
}