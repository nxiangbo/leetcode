package leetcode.hashtable;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    for(char c = '1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)){
                                return true;
                            } else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char c){
        for(int row=0; row<9; row++){
            if(board[row][j]==c) return false;
        }
        
        for(int col=0; col<9; col++){
            if(board[i][col]==c) return false;
        }
        
        int x = (i/3)*3;
        int y = (j/3)*3;
        
        for(int k=x; k<x+3; k++){
            for(int l=y; l<y+3; l++){
                if(board[k][l]==c)  return false;
            }
        }
        
        return true;
    }
}
