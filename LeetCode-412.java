class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> strList = new ArrayList<>();
        for(int i = 1 ; i <= n ; ){
            if(i%3 != 0 && i%5 != 0){
                strList.add(Integer.toString(i));
                i++;
                continue;
            }
            else{
            if(i%3==0 && i%5==0){
                strList.add("FizzBuzz");
                i++;
                continue;
            }
            else if(i%3 == 0){
                strList.add("Fizz");
                i++;
                continue;
            }
            else if(i%5 == 0){
                strList.add("Buzz");
                i++;
                continue;
            } else{
                strList.add(Integer.toString(i));
                i++;
                continue;
            }
            }
        }
        return strList;
    }
}