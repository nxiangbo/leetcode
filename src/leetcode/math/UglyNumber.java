package leetcode.math;

public class UglyNumber {
	public static boolean isUgly(int num) {
		if (num == 1) {
			return true;
		}
		if(num == 0){
			return false;
		}
		if(num == Integer.MIN_VALUE){
			return false;
		}
		if(num < 0){
			return false;
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
//		
		for (int i = 7; i < Math.sqrt(num); i+=2) {
			while((num % i) == 0){
				num = num/i;
				if(i>5){
					return false;
				}
			}
		}
		
		if(num>5){
			return false;
		}
//		int i = 2;
//		while (i<num/2) {
//			if((num%i)==0){
////				System.out.println(i);
//				if(isPrime(i)){
//					System.out.println(i);
//					if(i > 5){
//						return false;
//					}
//				}
//			}
//			i++;
//		}
//		
		return true;
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
