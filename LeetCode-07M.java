class Solution {
    public int reverse(int x) {
        int temp = 1 ;
        int type = Integer.signum(x);
        x = (int)Math.abs(x);
        String s = Integer.toString(x);
        StringBuilder total = new StringBuilder() ;
        
        for(int i = 0 ; s.length() > i ; i++){
            int lastind = (s.length() - 1) - i ;
            total.append(s.charAt(lastind));
        }

        int finalnum;
        try {
            finalnum = Integer.parseInt(total.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
       
        return (type==1) ? finalnum : -finalnum;
        
    }
}
