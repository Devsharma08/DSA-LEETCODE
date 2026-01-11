class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            char[] w1 = words[i].toCharArray();
            char[] w2 = words[i + 1].toCharArray();

            boolean isSorted = false; 

            for (int j = 0; j < Math.min(w1.length, w2.length); j++) {
                int rank1 = orderMap[w1[j] - 'a'];
                int rank2 = orderMap[w2[j] - 'a'];

                if (rank1 > rank2) {
                    return false;
                } 
                else if (rank1 < rank2) {
                    isSorted = true;
                    break; 
                }
            }
            if (!isSorted && w1.length > w2.length) {
                return false;
            }
        }
        return true;
    }
}