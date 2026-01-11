import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
            int sizeL1 = s1.length();
            int sizeL2 = s2.length();

            if (sizeL1 > sizeL2) return false;

            int[] list1 = new int[26];
            int[] list2 = new int[26];

            for(int i = 0 ; sizeL1 > i ; i++){
                list1[ s1.charAt(i) - 'a' ]++;
                list2[ s2.charAt(i) - 'a' ]++;
            }

            for(int i = sizeL1 ; sizeL2 > i ; i++){
                if(Arrays.equals(list1,list2)) return true;
                
                    // removing
                    list2[s2.charAt(i - sizeL1) - 'a']-- ;
                    // adding
                    list2[s2.charAt(i) - 'a']++ ;

            }
            return Arrays.equals(list1,list2);
        }
}