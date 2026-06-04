class Solution {
    public boolean checkValidString(String s) {
        int openP = 0 ; 
        int maxP = 0 ; 
        for(char ch : s.toCharArray()){
            if(ch=='('){
                openP++;
                maxP++;
            }
            if(ch==')'){
                openP--;
                maxP--;
            }
            if(ch=='*'){
                openP--;
                maxP++;
            }
            if(maxP<0) return false;
            if(openP<0) openP = 0 ; 
        }
        return openP==0;
    }
}