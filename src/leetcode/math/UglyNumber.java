package leetcode.math;

public class UglyNumber {
	public static boolean isUgly(int num) {
		if (num == 1) {
			return true;
		}
		
		while(num%2==0){
			num /= 2;
		}
		
		while(num%3==0){
			num /= 3;
		}
		
		while(num%5 == 0){
			num /= 5;
		}
		
		return (num==1);
	}
	
	public static boolean isPrime(int num){
		if(num ==1){
			return false;
		}
		
		int i = 2;
		for (i = 2; i <= num/2+1; i++) {
			if(num%i==0){
				return false;
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		int n = 9;
		int num = Integer.MAX_VALUE;
//		int num = Integer.MIN_VALUE;
//		System.out.println(isPrime(n));
		System.out.println(isUgly(n));
	}
}
