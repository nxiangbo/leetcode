package leetcode.trie;

class TrieNode {
	public  char val;
    public TrieNode[] next = new TrieNode[26];
    public boolean isWord;
    // Initialize your data structure here.
    public TrieNode() {
    }
    
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val =  ' ';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode x = root;
        for(int i=0;i<word.length();i++){
        	char c = word.charAt(i);
        	if(x.next[c-'a']==null){
        		x.next[c-'a'] = new TrieNode(c);
        	}
        	x = x.next[c-'a'];
        }
        
        x.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode x = root;
        for(int i=0;i<word.length();i++){
        	char c = word.charAt(i);
        	if(x.next[c-'a']==null) return false;
        	x = x.next[c-'a'];
        }
        
        return x.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode x = root;
        for(int i=0;i<prefix.length();i++){
        	char c = prefix.charAt(i);
        	if(x.next[c-'a']==null) return false;
        	x = x.next[c-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");