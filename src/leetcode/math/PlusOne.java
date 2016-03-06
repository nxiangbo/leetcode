package leetcode.math;

public class PlusOne {
	 public static int[] plusOne(int[] digits) {
		 if(digits.length<=0){
			 int[] result = {1};
			 return result;
		 }
		 if(digits[digits.length-1]<9){
			 digits[digits.length-1] = digits[digits.length-1]+1;
			 return digits;
		 }
		 
		 int sum = 0;
		 int one = 1;
		 for (int i = digits.length-1; i >= 0; i--) {
			 sum = digits[i]+one;
			 one = sum/10;
			 digits[i] = sum%10;
		 }
		 if(one==1){
			 int[] result = new int[digits.length+1];
			 result[0] = 1;
			 for (int i = 1; i < result.length; i++) {
				result[i] = digits[i-1];
			}
			return result;
		 } else{
			 return digits;
		 }
	}
	 
	 public static void main(String[] args) {
		int[] digits = {9,9,9,9,9};
		plusOne(digits);
	}
}
