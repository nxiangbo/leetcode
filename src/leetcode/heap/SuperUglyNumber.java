package leetcode.heap;

public class SuperUglyNumber {
	/**
	 * ±©Á¦½â·¨
	 * @param n
	 * @param primes
	 * @return
	 */
	public static int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1) {
			return 1;
		}
		int count = 1;
		int num = 2;
		while (true) {
			int temp = num;
			if (isSuperUglyNumber(temp, primes)) {
				count++;
			}
			if (count == n) {
				break;
			}
			// System.out.println(num);
			num++;
		}
		return num;

	}

	public static boolean isSuperUglyNumber(int num, int[] primes) {
		for (int prime : primes) {
			while (num % prime == 0) {
				num /= prime;
			}
			if (num == 1) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Accepted
	 * @param n
	 * @param primes
	 * @return
	 */
	 public int nthSuperUglyNumber2(int n, int[] primes) {
	        int[] uglys = new int[n];
	        int[] idx = new int[primes.length];
	        
	        uglys[0] = 1;
	        for(int i=1;i<n; i++){
	            uglys[i] = Integer.MAX_VALUE;
	            for(int j = 0;j<primes.length;j++){
	                uglys[i] = Math.min(uglys[i], primes[j]*uglys[idx[j]]);
	            }
	            
	            for(int j =0;j<primes.length;j++){
	                while(primes[j]*uglys[idx[j]]<=uglys[i]) idx[j]++;
	            }
	        }
	        return uglys[n-1];
	    }

	public static void main(String[] args) {
		int[] primes = {2,3,5};
		int n = 4;
		System.out.println(nthSuperUglyNumber(n, primes));
	}
}
