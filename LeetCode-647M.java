import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.nextLine();

        if (s.length() == 0 || s == "")
            System.out.println(0);

        int right = s.length() - 1;

        int left = 0;

        int count = subString(s, left, right);
        scn.close();
        System.out.println(count);

    }

    private static int subString(String str, int left, int right) {

        int count = str.length();

        while (left <= right) {

            int i = left;

            int j = right;

            while (j >= i) {

                if (str.charAt(j) == str.charAt(i)) {

                    i++;

                    j--;

                    count++;

                    continue;

                }

            }

            left++;

            right--;

        }

        return count;

    }

}