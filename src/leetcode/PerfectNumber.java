package leetcode;

import java.util.Scanner;

public class PerfectNumber {
	public static int countPerfectNumber(int num1, int num2){
		int count = 0;
		for (int i = num1; i <= num2; i++) {
			if(isPerfectNumber(i)){
				count ++;
			}
		}
		return count;
	}

	private static boolean isPerfectNumber(int num) {
		int sum = 0;
		for (int i = 1; i <= num/2; i++) {
			if(num%i==0){
				sum += i;
			}
		}
		return (sum==num)?true:false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			System.out.println(countPerfectNumber(num1, num2));
		}
	}
}
