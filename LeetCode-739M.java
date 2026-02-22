class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> st = new Stack<>();
        int tempSize = temperatures.length;
        int l[] = new int[tempSize];
        // looping throught loop

        for(int i = 0 ; tempSize > i ; i++){
            while( !st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int prevIndx = st.pop();
                l[prevIndx] = i - prevIndx;        
            } 
            st.push(i);
        }
        return l;
    }
}