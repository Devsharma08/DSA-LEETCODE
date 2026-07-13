class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[size];
        visited[0] = true;
        list.add(0);
        backtrack(visited, list, size, n);
        return list;
    }

    public static boolean backtrack(boolean[] visited, ArrayList<Integer> list, int size, int n) {
        int currentSize = list.size();
        if (currentSize == size) {
            int lstNum = list.get(currentSize - 1);
            int fstNum = list.get(0);
            int t1 = lstNum ^ fstNum; 
            return t1 > 0 && ((t1 & (t1 - 1)) == 0);
        }

        int temp = list.get(currentSize - 1);
        for (int bit = 0; bit < n; bit++) {
            int nextNum = temp ^ (1 << bit);
            
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                list.add(nextNum);
                
                if (backtrack(visited, list, size, n)) return true;
                
                list.remove(list.size() - 1);
                visited[nextNum] = false;
            }
        }
        return false;
    }
}
