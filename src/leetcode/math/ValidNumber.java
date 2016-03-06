package leetcode.math;
/**
 * 	Validate if a given string is numeric.
 *	Some examples:
 *	"0" => true
 *	" 0.1 " => true
 *	"abc" => false
 *	"1 a" => false
 * 	"2e10" => true
 * 
 * ����һ��Сʱ�����ǲ��ܱ�accepted�����������ˡ�����
 * ����һ��Discussion��������������ʽ��Ҳ�ͼ��е����顣�κο���������
 * Ҫ��һ�������������ʽ��ʾһ��numeric
 * 
 * @author nxiangbo
 *
 */
public class ValidNumber {
	public static boolean isNumber(String s) {
//		boolean isNumber = false;
		boolean isFirstDot = true;
		boolean isFirstE = true;
		s = s.trim();
		if(s.length()<=0){
			return false;
		}
		if(s.length()==1){
			if(s.charAt(0)>='0' && s.charAt(0)<='9'){
				return true;
			} else{
				return false;
			}
		}
		if(s.equals("+.")||s.equals("-.")){
			return false;
		}
		int i = 0;
		if(s.charAt(i)=='+'||s.charAt(i) == '-'||s.charAt(i)>='0'&&s.charAt(i)<='9'){
			i++;
		} else if(s.charAt(i) == '.' && isFirstDot && i!= s.length()-1){
			isFirstDot = false;
			i++;
		}
		else{
			return false;
		}
		
		while (i<s.length()) {
			if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
				i ++;
//				System.out.println(i);
			}
			else if(s.charAt(i) == '.' && isFirstDot){
				isFirstDot = false;
				if(s.charAt(i-1) == 'e'){
					break;
				}
				i++;
			}
			
			else if(s.charAt(i) == 'e' && isFirstE && i != s.length()-1){
				isFirstE = false;
				if(s.charAt(i-1) == '.' && i == s.length()-1 ||s.charAt(i-1) == '.' && i-1 == 0|| s.charAt(i-1) == '-' || s.charAt(i-1) =='+'){
					break;
				}
				i++;
			} else{
				break;
			}
			
		}
		if(i==s.length()){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		String s = ".e32";
		System.out.println(isNumber(s));
	}
}
