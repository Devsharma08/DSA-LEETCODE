class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int num = n ;
        int total = 0 ;
        while( num > 1 ){
            while(num > 0){
                int rem = num % 10 ;
                total += ( rem * rem ) ; 
                num = num / 10 ;
            }
            if(total == 1) return true;
            if(!set.contains(total)){
                set.add(total);
                num = total;
            } else{
                return false;
            }
            total = 0 ;

        }
        return true;
    }
}