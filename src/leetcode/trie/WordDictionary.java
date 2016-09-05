package leetcode.trie;

public class WordDictionary {
    class Node{
        public char val;
        public Node[] next = new Node[26];
        public boolean isWord;
        
        public Node(){}
        
        public Node(char c){
            Node node = new Node();
            node.val = c;
        }
    }
    
    private Node root;
    public WordDictionary(){
        root = new Node();
        root.val = ' ';
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        Node x = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(x.next[c-'a']==null){
                x.next[c-'a'] = new Node(c);
            }
            x = x.next[c-'a'];
        }
        x.isWord = true;
    }
    
    public boolean search(String word){
    	return search(word.toCharArray(), 0, root);
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(char[] chars, int k, Node node) {
        if(chars.length==k) return node.isWord;
        
        if(chars[k]=='.'){
        	for(int i=0;i<node.next.length;i++){
        		if(node.next[i]!=null){
        			if(search(chars, k+1, node.next[i])){
        				return true;
        			}
        		}
        	}
        } else{
        	return node.next[chars[k]-'a']!=null && search(chars, k+1, node.next[chars[k]-'a']);
        }
        return false;
    }
    
    public static void main(String[] args) {
		WordDictionary wd = new WordDictionary();
		wd.addWord("lab");
		wd.addWord("bat");
		wd.addWord("hat");
		
		System.out.println(wd.search("lab"));
		System.out.println(wd.search("sa."));
		System.out.println(wd.search(".at"));
		
		
	}
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
