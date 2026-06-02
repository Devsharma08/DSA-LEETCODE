class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] c = new int[26];
        int len = s.length();

        for(int i = 0 ; len > i ; i++ ){
            c[s.charAt(i) - 'a'] = i ;
        }
        List<Integer> list = new ArrayList<>();
        int prev = 0 ; 
        int end = 0 ;

        for(int i = 0 ; len > i ; i++ ){
            if(c[s.charAt(i) - 'a'] > end ){
                end = c[s.charAt(i) - 'a'] ;
            }
            if(i==end){
                list.add(end-prev+1);
                prev = end + 1;
            }
        }
        return list;
    }
}