package leetcode;

import java.util.ArrayList;

public class ReverseInteger {
	public  static int reverse(int x) {
		int result = 0;
		int flag = 1;
//		int[] nums = null;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		if (x == 0) {
			return result;
		}
		if(x>=Integer.MAX_VALUE){
			return result ;
		}
		if (x < 0) {
			flag = -1;
			x = -x;
		}
		
		while (x > 0) {
			nums.add((x)%10);
			x = x/10;
		}
		for (int i = 0; i < nums.size(); i++) {
			result += nums.get(i)*Math.pow(10, nums.size()-i-1);
			System.out.println("result = "+result);
			if(result>=Integer.MAX_VALUE){
				result = 0;
				break;
			}
		}
		result = flag*result;
		return result;
	}
	
	public static void main(String[] args) {
		int x = 1000000003;
		System.out.println(reverse(x));;
	}
}
