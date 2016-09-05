package leetcode.dp;

public class LongestCommonConSubsequence {
	public static int longestCommonConSubsequence(String str1, String str2){
		int m = str1.length();
		int n = str2.length();
		
		int[][] c = new int[m+1][n+1];
		int result = 0;
		int maxIndex = 0;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					c[i][j] = c[i-1][j-1]+1;
				} else{
					c[i][j] =0;
				}
				if(c[i][j]>result){
					result = c[i][j];
					maxIndex = i+1-result;
				}
				
			}
		}
		String str = str1.substring(maxIndex-1,maxIndex+result-1);
		System.out.println(str);
		return result;
	}
	
	public static void main(String[] args) {
		String str1 = "afsklabsd";
		String str2 = "sdjsabsdfg";
		System.out.println(longestCommonConSubsequence(str1, str2));
	}
}
