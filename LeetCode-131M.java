class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result , s , new ArrayList<>() , 0 );
        return result;
    }

    public void backtrack(List<List<String>> result,String s,ArrayList<String> curr,int st){
        if(st==s.length()){
            result.add(new ArrayList<>(curr));
            return ;
        }
        for(int end = st ; s.length() > end ; end++){
            if(isPalindrome(s,st,end)){
                curr.add(s.substring(st,end+1));
                backtrack(result,s,curr,end+1);
                curr.remove(curr.size()-1);
            }

        }

    }

    public boolean isPalindrome(String s , int st,int end){
        while(end > st){
            if(s.charAt(st++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

}