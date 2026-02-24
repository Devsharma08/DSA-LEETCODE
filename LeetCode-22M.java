class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        backtracking(l,s,0,0,n);
        return l;
        
    }

    public void backtracking(List<String> l,StringBuilder s, int open,int close , int max){
        if(s.length()==max*2){
            l.add(s.toString());
            return;
        }
        if(open < max){
            s.append("(");
            backtracking(l,s,open+1,close,max);
            s.deleteCharAt(s.length()-1);

        }
        if(close<open){
            s.append(")");
            backtracking(l,s,open,close+1,max);
            s.deleteCharAt(s.length()-1);
        }
    }
}