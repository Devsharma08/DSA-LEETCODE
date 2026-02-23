class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> st = new Stack<>();
        for(String ch : tokens){
            if(isOper(ch)){
                int a = st.pop();
                int b = st.pop();
                int c = calc(ch,a,b);
                st.push(c);
            }
            else{
                st.push(Integer.parseInt(ch));
            }
        }
        return st.pop();
    }
    public boolean isOper(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int calc(String s,int a,int b ){
        switch(s){
            case "*":    return a * b;
            case "+":    return a + b;
            case "-":    return b - a;
            case "/":    return b / a;
            default: throw new IllegalArgumentException("invalid argument");
        }
    }
}