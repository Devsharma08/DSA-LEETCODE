class Solution {
    public String addBinary(String a, String b) {

        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        char carry = 0;

        StringBuilder str = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || carry == 1) {
            int temp1 = len1 >= 0 ? a.charAt(len1) - '0' : 0;
            int temp2 = len2 >= 0 ? b.charAt(len2) - '0' : 0;

            if (temp1 == 1 && temp2 == 1) {
                if (carry == 1) {
                    str.append('1');
                    carry = 1;
                } else {
                    str.append('0');
                    carry = 1;
                }
            } else if (temp1 == 0 && temp2 == 0) {
                if (carry == 1) {
                    str.append('1');
                    carry = 0;
                } else {
                    str.append('0');
                    carry = 0;
                }

            } else {
                if (carry == 1) {
                    str.append('0');
                    carry = 1;
                } else {
                    str.append('1');
                    carry = 0;
                }

            }
            len1--;
            len2--;
        }

        return str.reverse().toString();
    }
}