package leetcode.math;

public class UglyNumberII {
	public static int nthUglyNumber(int n) {
		int count = 0;
		int num = 1;
		
		while(count<n){
			if(isUgly(num)){
				count++;
			}
			num++;
		}
		return num-1;
	}
	
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
	
	public static int nthUglyNum(int n) {
		if(n<=0){
			return 0;
		}
		
		int[] uglys = new int[n];
		uglys[0] = 1;
		int index = 1;
		int index2 = 0,index3=0,index5=0;
		int mul2 = 1, mul3 = 1,mul5 = 1;
		while(index<n){
			uglys[index] = min(mul2*2,mul3*3,mul5*5);
			while(mul2*2<=uglys[index])
				mul2 = uglys[++index2];
			while(mul3*3<=uglys[index])
				mul3 = uglys[++index3];
			while(mul5*5<=uglys[index])
				mul5 = uglys[++index5];
			index++;
		}
		return uglys[index-1];
	}
	
	private static int min(int i, int j, int k) {
		int min = i<j?i:j;
		min = min<k?min:k;
		return min;
	}

	public static void main(String[] args) {
		int n = 1438;
		System.out.println(nthUglyNum(n));
	}
}
