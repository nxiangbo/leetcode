package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.trie.Trie;

public class WordSearchII {
	
	private Set<String> result = new HashSet<>();
	public List<String> findWords(char[][] board, String[] words) {
		int m = board.length;
		int n = board.length;
		Trie trie = new Trie();
		boolean[][] used = new boolean[m][n];
		for(String word:words){
			trie.insert(word);
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dfs(board, "", used, i, j, trie);
			}
		}
		
		return new ArrayList<>(result);
	}
	
	public void dfs(char[][] board,String word, boolean[][] used, int i, int j, Trie trie){
		if(i<0||j<0||i>=board.length ||j>=board[0].length) return;
		if(used[i][j]) return;
		
		word+=board[i][j];
		if(!trie.startsWith(word)){
			return;
		}
		
		if(trie.search(word)){
		    result.add(word);
		}
		
		used[i][j] = true;
		dfs(board, word, used, i+1, j, trie);
		dfs(board, word, used, i, j+1, trie);
		dfs(board, word, used, i-1, j, trie);
		dfs(board, word, used, i, j-1, trie);
		used[i][j] = false;
	}
}
