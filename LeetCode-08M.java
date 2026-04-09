class Solution {
    public int myAtoi(String s) {

        // remove white spaces from the end
        s = s.trim();


        // string length
        int strLen = s.length();

        // incase of empty string return 0
        if(strLen == 0) return 0;
        // is leading zero 
        boolean isLeadingZero = true; 

        // is negative
        boolean isNegative = false;

        long total = 0 ;
        // start from the first character
        int i = 0 ;

        if( s.charAt(0) == '-' || s.charAt(0) == '+' ){
                isNegative = s.charAt(0)=='-' ? true : false  ;
                i = 1;
        }

        for( ; strLen > i ; i++){
    
            char ch = s.charAt(i);

            if(!Character.isDigit(ch)) break; 
            int digit = ch - '0';

            total = ( total * 10 ) + digit;

            // checking for over flow conditions 
            if (isNegative == false  && total > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNegative == true && -total < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return isNegative==true ? (int)(-total) : (int)total;
    }
}