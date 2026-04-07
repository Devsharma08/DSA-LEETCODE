class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        int stringLen = s.length();
        StringBuilder sb = new StringBuilder();

        // making list storing string and at last adding everythings
        List<StringBuilder> list = new ArrayList<>();

        // making ArrayList of count rows count
        for(int i = 0 ; i < numRows ; i++){
            list.add(new StringBuilder());
        }

        // now adding characters into the stringbuilders
        int listIndex = 0 ;
        boolean hitBottom = false;
        for(int i = 0 ; stringLen > i ; i++){
            list.get(listIndex).append(s.charAt(i));
            if(listIndex == 0 ){
                hitBottom =  false ;
            } else if(listIndex == numRows-1){
                hitBottom = true;
            } 
            listIndex += hitBottom == false ? 1 : -1 ; 
            // int temp = listIndex;

        }
        // concat all the strings
        for(StringBuilder temp:list){
            sb.append(temp);
        }
        return sb.toString();
    }
}