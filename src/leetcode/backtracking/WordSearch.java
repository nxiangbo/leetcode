package leetcode.backtracking;


public class WordSearch {

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		if (m <= 0)
			return false;
		int n = board[0].length;

		boolean[][] used = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (exist(board, word, used, i, j, 0))
					return true;
			}
		}

		return false;
	}

	public boolean exist(char[][] board, String word, boolean[][] used, int i,
			int j, int k) {
		if (word.length() == k) {
			return true;
		}

		if (i < 0 || j < 0 || i == board.length || j == board[i].length)
			return false;
		if (board[i][j] != word.charAt(k) || used[i][j])
			return false;
		used[i][j] = true;
		boolean exists = exist(board, word, used, i + 1, j, k + 1)
				|| exist(board, word, used, i, j + 1, k + 1)
				|| exist(board, word, used, i - 1, j, k + 1)
				|| exist(board, word, used, i, j - 1, k + 1);
		used[i][j] = false;
		return exists;
	}
}
