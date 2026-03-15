class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> hash = new HashMap<>();

        // preaparing freq map for tasks
        for(char ch:tasks){
            if(!hash.containsKey(ch)){
                hash.put(ch,0);
            }
            int temp = hash.get(ch);
            hash.put(ch,temp+1);
        }

        // arranging freq count for every char in hashmap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.addAll(hash.values());

        int count = 0 ;
        // final prep for count 
        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int task = n+1;
            int tempTask = 0 ;

            // adding to tasks form queue to the list
            while(!pq.isEmpty() && task > tempTask){
                list.add(pq.poll());
                tempTask++;
            }
            
            for (int freq : list) {
                if (--freq > 0) pq.offer(freq);
            }

            count += !pq.isEmpty() ? task : tempTask; 

    }
    return count;
    }
}