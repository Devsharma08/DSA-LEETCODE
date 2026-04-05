public class TrieNode{
    int size = 20;
    TrieNode[] arr ;
    boolean isEnd;
    TrieNode(){
        arr = new TrieNode[26]; 
        isEnd = false;
    }
} 

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray()){
            if(temp.arr[ch-'a']==null){
                TrieNode newNode = new TrieNode();
                // for storing the ref for later
                temp.arr[ch-'a'] = newNode;

            }
            // passing the ref
            temp = temp.arr[ch-'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;

        for(char ch:word.toCharArray()){
            TrieNode trieChar = temp.arr[ch-'a'] ;
            if(trieChar==null){
                return false;
            }
            temp = temp.arr[ch-'a'];
        }
        if(temp.isEnd) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;

        for(char ch:prefix.toCharArray()){
            TrieNode trieChar = temp.arr[ch-'a'] ;
            if(trieChar==null){
                return false;
            }
            temp = temp.arr[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */