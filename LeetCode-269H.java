class Solution {

    public boolean dfs(char ch, Map<Character, List<Character>> adj, boolean[] visited, boolean[] visiting, StringBuilder str) {
        if (visiting[ch - 'a']) return false; // this is used for cycle detection
        if (visited[ch - 'a']) return true; // just to know whether node has been prev. visited or not
        visiting[ch - 'a'] = true;
        if (adj.containsKey(ch)) {
            for (char next : adj.get(ch)) {
                if (!dfs(next, adj, visited, visiting, str)) return false;
            }
        }
        visiting[ch - 'a'] = false;
        visited[ch - 'a'] = true;
        str.append(ch);
        return true;
    }

    public String foreignDictionary(String[] words) {
        int n = words.length;
        Map<Character, List<Character>> adj = new HashMap<>();
        boolean[] exists = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) exists[c - 'a'] = true;
        }

        for (int i = 1; i < n; i++) {
            String f = words[i - 1];
            String l = words[i];
            int len = Math.min(f.length(), l.length());
            if (f.length() > l.length() && f.startsWith(l)) return "";
            for (int j = 0; j < len; j++) {
                if (f.charAt(j) != l.charAt(j)) {
                    adj.computeIfAbsent(f.charAt(j), k -> new ArrayList<>()).add(l.charAt(j));
                    break;
                }
            }
        }

        StringBuilder str = new StringBuilder();
        boolean[] visited = new boolean[26];
        boolean[] visiting = new boolean[26];

        for (int i = 25; i >= 0; i--) {
            if (exists[i] && !visited[i]) {
                if (!dfs((char) ('a' + i), adj, visited, visiting, str)) return "";
            }
        }
        return str.reverse().toString();
    }
}