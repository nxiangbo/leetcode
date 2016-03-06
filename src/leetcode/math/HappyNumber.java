package leetcode.math;

import java.util.ArrayList;

public class HappyNumber {
	public static boolean isHappy(int n) {
//		boolean ishappy = false;
		int num = 0;
		while (n!=1&&n!=4) {
			while (n>0) {
//				digits.add(n % 10);
				num += (n%10)*(n%10);
				n = n / 10;
				System.out.println(num);
			}
			n = num;
			num = 0;
//			n = square(digits);
//			isHappy(n);
		}

		return n==1;

	}

	public static int square(ArrayList<Integer> digits) {
		int n = 0;
		for (int i = 0; i < digits.size(); i++) {
			n += Math.pow(digits.get(i), 2);
		}
		return n;
	}

	public static void main(String[] args) {
		int n = 3254;
		System.out.println(isHappy(n));
	}
}
