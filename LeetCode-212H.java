class TrieNode {
    TrieNode[] arr;

    TrieNode() {
        arr = new TrieNode[26];
    }

    String word = null;
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = makingTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        
        // Boundary & Trie Check
        // If we hit a '#' (visited) or the letter isn't a path in the Trie, stop.
        if (c == '#' || node.arr[c - 'a'] == null) {
            return;
        }

        // Move to the next Trie node
        node = node.arr[c - 'a'];
        
        // Check if found a word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Mark null so we don't add the same word twice
        }

        // Mark as visited (Backtracking start)
        board[i][j] = '#';

        // Explore 4 directions
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);

      
        board[i][j] = c;
    }

    public TrieNode makingTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode temp = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (temp.arr[i] == null) {
                    temp.arr[i] = new TrieNode();
                }
                temp = temp.arr[i];
            }
            temp.word = word; 
        }
        return root;
    }
}