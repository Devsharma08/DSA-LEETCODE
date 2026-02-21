class Solution {
    char setValue(char t) {
        switch(t) {
            case '}': return '{';
            case ']': return '[';
            case ')': return '(';
            default:  return ' ';
        }
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '[' || temp == '{' || temp == '(') {
                st.push(temp);
            } 
            else {
                if (st.isEmpty() || st.peek() != setValue(temp)) {
                    return false;
                }
                st.pop();
            }
        } 
        return st.isEmpty();
    }
}