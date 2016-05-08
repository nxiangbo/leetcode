package leetcode;

public class ReverseBits {
	public static int reverseBits(int n) {
		long result = 0;
		int count = 31;
		while (n != 0) {
			int bit = n % 2;
			n = n >>> 1;
			if (bit == 1) {
				result += Math.pow(2, count);
			}
			if (result >= Integer.MAX_VALUE) {
				result = Integer.MAX_VALUE;
				return (int) result;
			}
			count--;

		}
		return (int) result;
	}
	
	public static int reverseBits2(int n){
		int result =0;
		for (int i = 0; i < 32; i++) {
			result+=n&1;
			n = n>>>1;
			if(i<31){
				result<<=1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 1;
		System.out.println(reverseBits2(n));
	}
}
