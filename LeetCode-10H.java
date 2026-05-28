class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] ans = new boolean[len1 + 1][len2 + 1];       
        ans[0][0] = true;

        for (int j = 1; j <= len2; j++) {
            if (p.charAt(j - 1) == '*') {
                ans[0][j] = ans[0][j - 2]; 
            }
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (sChar == pChar || pChar == '.') {
                    ans[i][j] = ans[i - 1][j - 1];
                } 
                else if (pChar == '*') {
                    ans[i][j] = ans[i][j - 2]; 

                    char precPChar = p.charAt(j - 2);
                    if (precPChar == sChar || precPChar == '.') {
                        ans[i][j] = ans[i][j] || ans[i - 1][j]; 
                    }
                }
            }
        }
        return ans[len1][len2];
    }
}