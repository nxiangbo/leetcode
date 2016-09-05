package leetcode.unionfind;

public class NumberOfIsland {
	public int numIslands(char[][] grid) {
        if(grid.length<=0 || grid[0].length<=0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // System.out.println(count+" "+grid[i][j]);
                if(grid[i][j]=='1'){
                    
                    count++;
                    isIsland(grid,i,j);
                }
            }
        }
        return count;
    }
    
    public void isIsland(char[][] grid, int i, int j){
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        if(i>0 ){
            isIsland(grid,i-1,j);
        }
        if(i<grid.length-1){
            isIsland(grid,i+1,j);
        }
        
        if(j>0){
            isIsland(grid,i,j-1);
        }
        
        if(j<grid[0].length-1){
            isIsland(grid,i,j+1);
        }
        
        
    }
}
