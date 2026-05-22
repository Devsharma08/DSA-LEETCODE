class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0) return list;
        List<Integer> tt = new ArrayList<>();
        tt.add(1);
        list.add(tt);
        if(numRows==1) return list;
        int size = 1;

        for(int i = 0 ; numRows-1 > i ; i++){
            ArrayList<Integer> t = new ArrayList<>();
            t.add(1);
            for(int j = 1 ; j < size ; j++){
                t.add(list.get(i).get(j-1)+list.get(i).get(j));
            }            
            t.add(1);
            list.add(t);
            size = t.size();
        }
        return list;
    }
}