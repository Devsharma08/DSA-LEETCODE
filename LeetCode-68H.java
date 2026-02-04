import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            
            int j = i + 1;
            int lineLetters = words[i].length();
            
           
            while (j < words.length && (lineLetters + words[j].length() + (j - i) <= maxWidth)) {
                lineLetters += words[j].length();
                j++;
            }

            int numberOfWords = j - i;
            StringBuilder sb = new StringBuilder();

            
            if (j == words.length || numberOfWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
               
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            // Scenario B: Normal Line (Full Justify)
            else {
                int totalSpaces = maxWidth - lineLetters;
                int gapCount = numberOfWords - 1;
                int baseSpaces = totalSpaces / gapCount;
                int extraSpaces = totalSpaces % gapCount;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spacesToAdd = baseSpaces + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToAdd; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}