class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        // populate treemap with key and freq. count  
        for (int t : hand) {
            tree.put(t, tree.getOrDefault(t, 0) + 1);
        }

        while (!tree.isEmpty()) {
            int first = tree.firstKey();
            
            for (int k = 0 ; groupSize > k ; k++ ) {
                int curr = first+k ;
                if(!tree.containsKey(curr)) return false;
                int val = tree.get(curr);
                if(val==1){
                    tree.remove(curr);
                } else{
                    tree.put(curr,tree.get(curr)-1);
                }
                
            }
        }
        return true;
    }
}