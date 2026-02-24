class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack <Character> st = new Stack<>();
        Stack <Integer> deletedSt = new Stack<>();
        StringBuilder str = new StringBuilder(s);
        for(int i = 0 ; i < s.length() ; i++ ){
            char temp = s.charAt(i);
            if(temp==')' && st.isEmpty() ){
                deletedSt.push(i);
            }
           if(temp=='('){
                st.push(temp);
                deletedSt.push(i);
            }
            if(temp==')' && !st.isEmpty() && temp!=st.peek()){
                st.pop();
                deletedSt.pop();
            }
        }
        while(!deletedSt.isEmpty()){
            str.deleteCharAt(deletedSt.pop());
        }
        return str.toString();
    }
}