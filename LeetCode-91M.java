class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        if(s.contains("00")) return 0;
        int f = 1 ; // holds the docoded count till ind 0
        int v = 1 ;
        int len = s.length();
        for( int i = 1 ; len > i ; i++ ){
            int temp = 0 ;
            char ch = s.charAt(i);
            if(ch!='0') temp = v;
            int val = Integer.parseInt(s.substring(i-1,i+1)); 
            if( val >= 10 && val < 27 ){
                temp = temp + f ;
            }
            f = v; 
            v = temp;
        }
        return v;
    }
}