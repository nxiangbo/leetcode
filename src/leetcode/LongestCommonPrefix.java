package leetcode;

public class LongestCommonPrefix {
	 public static String longestCommonPrefix(String[] strs) {
		 int minLen = Integer.MAX_VALUE;
		 String prefix = "";
		 int index = 0;
		 for(int i=0;i<strs.length;i++){
			 if(minLen>strs[i].length()){
				 minLen = strs[i].length();
				 prefix = strs[i];
				 index = i;
			 }
		 }
		 
		 for(int i=0;i<strs.length;i++){
			 while(!startWith(strs[i], prefix)&&i!=index&&prefix.length()>=1){
				 prefix = prefix.substring(0, prefix.length()-1);
			 }
			 
		 }
		 
		 return prefix;
		 
	 }
	 
	 public static boolean startWith(String str, String prefix){
		 int pLen = prefix.length();
		 int sLen = str.length();
		 if(pLen>sLen){
			 return false;
		 }
		 if(pLen<=0){
			 return false;
		 }
		 
		 for(int i=0;i<pLen;i++){
			 if(str.charAt(i)!=prefix.charAt(i)){
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public static void main(String[] args) {
		String[] str = {"caa","dsffdas","dsfs","dsfgf"};
		String prefix = "caa";
		String s = "hells";
		String p = "he";
		System.out.println(longestCommonPrefix(str));
//		System.out.println(startWith(s, p));
	}
}
