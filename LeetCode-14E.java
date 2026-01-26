class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minInd = 0 ;
        for(int i = 1 ; strs.length > i ; i++){
            if(strs[i].length() < strs[minInd].length()){
                minInd = i ;
            }
        }

        if(strs[minInd].equals("")) return "";

        for(int j = 0 ; j < strs[minInd].length() ; j++){
            char ch = strs[minInd].charAt(j);
            for(String str: strs ){
                if(str.charAt(j)==ch){
                    continue;
                } else{
                    return strs[minInd].substring(0,j);
                }

            }
        }
        return strs[minInd] ;
    }
}