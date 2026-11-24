class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        
        for(int i = 0 ; len/2 > i ; i++){
        int end = len-1-i;
        if(i==end) return;

        // if(end==i) return;
        char temp = s[i] ;
        s[i] = s[end];
        s[end] = temp; 
            
        }
    }

    public static void swap(char[] s, int st,int end){
        if(st==end) return;
        char temp = s[st] ;
        s[st] = s[end];
        s[end] = temp; 
    }
}