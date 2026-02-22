public class MaxStack{
    Stack <Integer> st;
    Stack <Integer> maxSt;
    public MaxStack(){
        st = new Stack<>();
        maxSt = new Stack<>();
    }
    public void push(int x){
        st.push(x);
        if(maxSt.isEmpty()||maxSt.peek()<=x){
            maxSt.push(x);
        }
    }
    public int pop(){
        if(!st.isEmpty()){
            int temp=st.pop();
            if(temp==maxSt.peek()){
                maxSt.pop();
            }
        }
        return -1;
    }
    public int top(){
        if(!st.isEmpty()){
            return st.peek();
        }
        return -1;
    }
    public int peekMax(){
        if(!maxSt.isEmpty()){
            return maxSt.peek();
        }
        return -1;
    }
    public int popMax(){
        if(!max.isEmpty()){
            int temp=maxSt.pop();
            if(temp==st.peek()){
                st.pop();
            } else{
                Stack<Integer> tempSt = new Stack<>();
                while(st.peek()!=temp){
                    tempSt.push(st.pop());
                }
                st.pop();
                while(!tempSt.isEmpty()){
                    push(tempSt.pop());
                }
                return temp;
            }
            }
        }
    }
