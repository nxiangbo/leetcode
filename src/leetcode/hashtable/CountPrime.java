package leetcode.hashtable;

public class CountPrime {
	public static boolean isPrime(int num){
		if(num==1){
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static int countPrime(int n){
		if(n==0 || n==1) return 0;
		int count = 0;
		int num = 1;
		while(num<n){
			if(isPrime(num)){
				count++;
				System.out.println("prime="+num);
			}
			num++;
		}
		return count;
	}
	
	/**
	 * Sieve of Eratosthenes
	 * @param n
	 * @return
	 */
	public static int countPrimes(int n){
		if(n<2){
			return 0;
		}
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		
		for(int i = 2; i*i<n;i++){
			if(!isPrime(i)) continue;
			for(int j = i*i;j<n;j+=i){
				isPrime[j] = false;
			}
		}
		
		int count = 0;
		for (int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int n = 1329;
		System.out.println(countPrimes(n));
	}
}
