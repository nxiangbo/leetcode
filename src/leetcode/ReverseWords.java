package leetcode;

public class ReverseWords {
	public static String reverseWords(String s) {
		s = s.trim();
		if(s==null||s.length()<=0){
			return null;
		}
		String result = "";
//		String[] words = s.split(" ");
		result = reverse(s);
		String finStr = "";
		int start = 0;
		for(int i=0;i<result.length();i++){
			if(Character.isWhitespace(result.charAt(i))){
				finStr +=reverse(result.substring(start, i))+result.charAt(i);
				start = i+1;
			}
		}
		
		finStr+=reverse(result.substring(start,result.length()))+" ";
		return finStr;
	}
	
	public static String reverseWordsI(String s){
		String result ="";
		if(s.length()<=0){
			return result;
		}
		String[] words = s.split(" ");
		for(int i = words.length-1;i>=1;i--){
			result+=words[i]+" ";
//			System.out.println(words[i]);
		}
		
		return result+words[0];
	}
	
	public static String reverse(String str){
		int low = 0;
		int high = str.length()-1;
		char[] words = str.toCharArray();
		while(low<high){
			char temp = words[low];
			words[low] = words[high];
			words[high] = temp;
			low++;
			high--;
		}
		return new String(words);
		
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	
	public static String reverseWordsII(String str){
		char[] s = str.toCharArray();
		reverseWords(s);
		return new String(s);
	}
	
	public static void reverseWords(char[] str){
		reverse(str,0,str.length);
		
		for(int i=0,j=0;j<=str.length;j++){
			if(j==str.length||str[j]==' '){
				reverse(str, i, j);
				i = j+1;
			}
		}
	}
	
	public static void reverse(char[] str, int start, int end){
		int low = start;
		int high = end-1;
		while(low<high){
			char temp = str[low];
			str[low] = str[high];
			str[high] = temp;
			low++;
			high--;
		}
		
	}
	
	public static void main(String[] args) {
		String result = "hello world! I am what I am.";
		System.out.println(reverseWordsII(result));
	}
}
