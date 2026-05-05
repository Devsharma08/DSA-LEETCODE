class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int total = 0 ;


        int len1 = num1.length();
        int len2 = num2.length();

        int[] arr = new int[len1+len2];

        for(int i = len1-1 ; 0 <= i ; i--){
            for(int j = len2-1 ; 0 <= j ; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') ;
                int p1 = i + j ;
                int p2 = i+j+1 ;
                int sum = mul + arr[p2];
                arr[p2] = sum%10;
                arr[p1] += sum/10;
                
            }
        }

        StringBuilder str = new StringBuilder();
        for(int pos : arr){
            if(pos==0 && str.length()==0){
                continue;
            }
            str.append(pos);
        }
        return str.toString();
    }
}