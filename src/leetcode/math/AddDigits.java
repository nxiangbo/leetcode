package leetcode.math;

public class AddDigits {
	public static int addDigits(int num) {
		int numTemp = 0;
		while(num>9){
			while(num>0){
				numTemp += num%10;
				num /= 10;
			}
			num = numTemp;
			numTemp = 0;
		}
		return num;
	}
	
	public static void main(String[] args) {
		int num = 38;
		System.out.println(addDigits(num));
	}
}
