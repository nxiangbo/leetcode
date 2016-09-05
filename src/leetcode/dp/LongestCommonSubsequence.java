package leetcode.dp;

public class LongestCommonSubsequence {
	public static int[][] longestCommonSubswquence(String str1, String str2){
		int m = str1.length();
		int n = str2.length();
		int[][] c = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					c[i][j] = c[i-1][j-1]+1;
				} else if(c[i-1][j]>=c[i][j-1]){
					c[i][j] = c[i-1][j];
				} else{
					c[i][j] = c[i][j-1];
				}
			}
		}
		return c;
	}
	
	public static void print(int[][] c, String str1,String str2, int i, int j){
		if(i==0||j==0){
			return ;
		}
		if(str1.charAt(i-1)==str2.charAt(j-1)){
			System.out.print(str1.charAt(i-1)+" ");
			print(c, str1, str2, i-1, j-1);
		} else if(c[i][j-1]>=c[i-1][j]){
			print(c, str1, str2, i, j-1);
		} else{
			print(c, str1, str2, i-1, j);
		}
	}
	
	
	public static void main(String[] args) {
		String str1 = "bdcaba";
		String str2 = "abcbdab";
		System.out.println(longestCommonSubswquence(str1, str2));
		int[][] c = longestCommonSubswquence(str1, str2);
		print(c, str1, str2, str1.length(), str2.length());
	}
}
