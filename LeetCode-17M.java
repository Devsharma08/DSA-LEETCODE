class Solution {
    private final String[] str = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        backtrack(result, digits, new StringBuilder(), str,0);
        return result;
    }

    public void backtrack(List<String> result, String digit, StringBuilder t, String[] str, int ind) {
        // int l = digit % 10;
        if (ind == digit.length()) {
            result.add(t.toString());
            return;
        }
        int currDigit = digit.charAt(ind) - '0';
        String tempStr = str[currDigit];
        for (int j = 0; tempStr.length() > j; j++) {
            backtrack(result,digit, t.append(tempStr.charAt(j)), str,ind+1);
            t.deleteCharAt(t.length() - 1);
        }
    }
}