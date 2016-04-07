package leetcode;

import java.util.Scanner;

public class Main {
//	public static int DemoDay(String[][] matrix){
//		for (int i = 0; i < matrix.length; i++) {
//			String[] rows = matrix[i];
//			
//			for (int j = 0; j < rows.length; j++) {
//				if(matrix[i][j].equals(".")){
//					
//				}
//			}
//		}
//	}
	
	  public static int test(int a[][],int result[][],int m,int n)
	    {
	    	if(m==0&&n==0)
	    	{
	    		return a[0][0];
	    	}
	    	else if(m==0)
	    	{
	    		result[0][n]=test(a,result,m,n-1)+a[0][n];	
	    	}
	    	else if(n==0)
	    	{
	    		result[m][0]=test(a,result,m-1,n)+a[m][0];	
	    	}
	    	else
	    	{
//	    		result[m][n]=min(test(a,result,m-1,n),test(a,result,m,n-1))+a[m][n];
	    	}
	    	return result[m][n];
	    	
	    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			int n = in.nextInt();
			String[][] matrix = new String[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = in.next();
				}
			}
		}
	}
}
