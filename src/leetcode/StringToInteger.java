package leetcode;

public class StringToInteger {
	public static int myAtoi(String str) {
		int result = 0;
		int flag = 1;
		String strs = str.trim();
//		System.out.println(strs);
		char[] chars = strs.toCharArray();
		if (chars.length <= 0) {
			return 0;
		}

		int i=0;
		if (chars[0] == '+') {
			flag = 1;
			i++;
		} else if (chars[0] == '-') {
			flag = -1;
			i++;
		} 
		for (; i < chars.length; ++i) {
			int num = chars[i] - 48;
			System.out.println(num);
			if(num<0||num>9){
				break;
			}
			if(result>Integer.MAX_VALUE/10||result == Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10){
				return flag == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
			} else{
				result = result*10+num;
			}
			
			System.out.println(result);
		}
		result = result * flag;
		return result;
	}
	

	public static void main(String[] args) {
		String str = "-2147483647";
		System.out.println(myAtoi(str));
	}
}
