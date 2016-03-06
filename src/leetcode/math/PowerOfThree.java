package leetcode.math;

public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		if(n == 1){
			return true;
		}
		if(n == 0){
			return false;
		}
		while(n%3==0){
			n/=3;
		}
		if(n!=1){
			return false;
		} else{
			return true;
		}
	}
	
	public boolean isPowerOfThree2(int n) {
		if(n<=0){
			return false;
		}
		double res = Math.log10(n)/Math.log10(3);
		if(res%1==0){
			return true;
		} else{
			return false;
		}
	}
	
}
