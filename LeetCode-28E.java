class Solution {
    public int strStr(String haystack, String needle) {
        int len = (haystack.length() - needle.length() + 1);
        int strLen = needle.length();
        for(int i = 0 ; len > i ; i++ ){
            if(needle.equals(haystack.substring(i,strLen+i))){
                return i;
            }
        }
        return -1;
    }
}