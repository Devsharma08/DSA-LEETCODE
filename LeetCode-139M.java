class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] ans = new boolean[len+1];
        ans[0] = true;
        Set<List<String>> set = new HashSet(wordDict);
        for(int i = 1 ; len >= i ; i++ ){
            for(int j = i ; 0 <= j ; j-- ){
                if(ans[j] && set.contains(s.substring(j,i))){
                    ans[i] = true;
                    break;
                }
            }
        }

        return ans[len];
    }
}