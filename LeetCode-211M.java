public class TrieNode {
    TrieNode arr[];
    boolean isLeaf;

    TrieNode() {
        arr = new TrieNode[26];
        isLeaf = false;
    }
}

class WordDictionary {
    public TrieNode root = new TrieNode();

    public WordDictionary() {
        // root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            int tempAdd = ch - 'a';
            if (temp.arr[tempAdd] == null) {
                temp.arr[tempAdd] = new TrieNode();
            }
            temp = temp.arr[tempAdd];
        }
        temp.isLeaf = true;
    }

    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }

    public boolean searchHelper(TrieNode root, int index, String word) {
        if (index == word.length()) return root.isLeaf;
        char ch = word.charAt(index);
        if ( ch== '.') {
            for (int i = 0; 26 > i; i++) {
                if (root.arr[i] != null && searchHelper(root.arr[i], index + 1, word)) {
                    return true;
                }
            }
            return false;
        } else {
            int charIdx = ch - 'a';
            if (root.arr[charIdx] == null) {
                return false;
            }
            return searchHelper(root.arr[charIdx], index + 1, word);
        }
    
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */