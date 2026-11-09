class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();

// creating freq table
        for(int card : deck){
            map.put(card,map.getOrDefault(card,0)+1);
        }

// checking for min freq 2
        int countGCD = 0 ;
        for(int temp : map.values()){
            countGCD = gcd(temp,countGCD);
        }
        return (countGCD >= 2)? true : false ;
    }

    public static int gcd(int temp,int num){
        if(num==0) return temp;
        // this statement will auto arrange for greater number to be at a(1st position) and smaller value to b
        return gcd(num,temp%num);
    }
}