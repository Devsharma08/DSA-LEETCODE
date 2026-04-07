class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==1) return s;
        int cycleLength = 2*numRows-2;
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; numRows > i ; i++){
            // int j = i;
            boolean firstJump = true;
            int gap = i;
            while( gap < s.length() ){
                sb.append(s.charAt(gap));
                int jump1 = cycleLength - (2*i);
                int jump2 = 2*i;
                if(i==0 || i==numRows-1){
                    gap += cycleLength; 
                } else{
                    if(firstJump){
                        gap+=jump1;
                    } else{
                        gap+=jump2;
                    }
                }
                firstJump = !firstJump ;
            }

        }
        return sb.toString();
        }
}