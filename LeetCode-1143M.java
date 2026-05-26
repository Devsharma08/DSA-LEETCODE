class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] db = new int[len1+1][len2+1];
        for(int i = 0 ; len1 > i ; i++){
            for(int j = 0 ; len2 > j ; j++){
                if(i==0 || j==0){
                    db[i][j] = 0;
                }
            }
        }

        for(int i = 1 ; len1+1 > i ; i++){
            for(int j = 1 ; len2+1 > j ; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    db[i][j] = db[i-1][j-1] + 1;
                    continue;
                }
                db[i][j] = Math.max(db[i-1][j],db[i][j-1]); // pick max from top or left
            }
        }
        return db[len1][len2];
    }
}