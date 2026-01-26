import java.util.*;

class Solution {
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String word : strs) {
            str.append(word.length()).append("/").append(word);
        }
        return str.toString();
    }

    public List<String> decode(String s) {
        int i = 0;
        List<String> list = new ArrayList<>();
        
        while (i < s.length()) {
            int slash = s.indexOf("/", i);
            int num = Integer.parseInt(s.substring(i, slash));
            i = slash + 1;
            list.add(s.substring(i, i + num));
            i = i + num;
        }
       
        return list;
    }
}