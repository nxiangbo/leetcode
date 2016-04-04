package leetcode.search;

public class Search2DMatrix {
	 public static boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix == null){
			 return false;
		 }
		 int rows = matrix.length-1;
		 int columns = matrix[0].length-1;
		 int row = 0;
		 while(row<=rows && columns >=0){
			 if(target == matrix[row][columns]){
				 return true;
			 } else if(target > matrix[row][columns]){
				 row++;
			 } else{
				 columns--;
			 }
		 }
		 
		 return false;
	 }
	 
	 public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{20, 30, 34, 50}};
		int target = 40;
		System.out.println(searchMatrix(matrix, target));
	}
}
