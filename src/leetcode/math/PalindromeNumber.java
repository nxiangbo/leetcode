package leetcode.math;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		int sum = 0;
		int temp = x;
		while (x > 0) {
			int bit = x % 10;
			x = x / 10;
			if(x==0){
				sum+=bit;
			}else{
				sum =sum*10 + bit * 10;
			}
			
		}
		return sum == temp;
	}
	
	public static void main(String[] args) {
		int x = 1432112129;
		
		System.out.println(isPalindrome(x));
	}
}
