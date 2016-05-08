package leetcode.math;

import java.util.Arrays;

public class NthSuperUglyNumber {
	public static int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
		if(n<=0 || primes.length<=0){
			return 0;
		}
		int index = 1;
		int[] uglys = new int[n];
		uglys[0] = 1;
		int[] mulIndex = new int[primes.length];
		int[] mul = new int[primes.length];
		for (int i = 0; i < mul.length; i++) {
			mul[i] = 1;
			mulIndex[i] = 0;
		}
		
		while(index<n){
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < primes.length; i++) {
				if(mul[i] * primes[i]<min){
					min = mul[i]*primes[i];
				}
			}
			uglys[index] = min;
			System.out.println(uglys[index]);
			for (int i = 0; i < mul.length; i++) {
				while(mul[i]*primes[i]<=uglys[index]){
				
					System.out.println(mul[i]+"  "+i);
					mul[i] = uglys[++mulIndex[i]];
				}
			}
			index++;
		}
		return uglys[index-1];
    }
	
	public static void main(String[] args) {
		int n = 10;
		int[] primes = {1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32};
		System.out.println(nthSuperUglyNumber(n, primes));
	}
}
