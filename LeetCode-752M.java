class Solution {
    public int openLock(String[] deadends, String target) {
        if(target=="0000") return 0;
        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
        if(deadend.contains("0000")) return -1;
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int step = 0 ;

        q.offer("0000");
        visited.add("0000");

        while(!q.isEmpty()){

            int size = q.size();
            for(int s = 0 ; s < size ; s++){
            String tempStr = q.poll();

            if(deadend.contains(tempStr)) continue;

            if(tempStr.equals(target)) return step;

                for(int i = 0 ; 4 > i ; i++){
                    char[] tempCh = tempStr.toCharArray();
                    int tempInt = tempCh[i] - '0';

                    // inc by one
                    tempCh[i] = (char)('0' + (tempInt + 1) % 10);
                    String str = new String(tempCh);
                    if(!deadend.contains(str) && visited.add(str)) q.offer(str);

                    // dec by 1
                    tempCh[i] = (char)('0' + ((tempInt + 9 ) % 10));
                    String str1 = new String(tempCh);
                    if(!deadend.contains(str1) && visited.add(str1)) q.offer(str1);
                }
            }
            step++;
        }
        return -1;
    }
}