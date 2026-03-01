class MyQueue {
    public Stack<Integer> st;  
    public Stack<Integer> end; 

    public MyQueue() {
        st = new Stack<>();
        end = new Stack<>();
    }

    public void push(int x) {
        end.push(x);
    }

    public int pop() {
        peek(); 
        return st.pop();
    }

    public int peek() {
        if (st.isEmpty()) {
            while (!end.isEmpty()) {
                st.push(end.pop());
            }
        }
        return st.peek();
    }

    public boolean empty() {
       
        return st.isEmpty() && end.isEmpty();
    }
}