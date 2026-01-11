class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;

        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left >= right) break;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
        }
        
        return true;
    }
}