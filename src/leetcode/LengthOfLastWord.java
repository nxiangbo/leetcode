package leetcode;

public class LengthOfLastWord {
	 public int lengthOfLastWord(String s) {
	        if(s==null||s.length()<=0){
	            return 0;
	        }
	        String[] strs = s.split(" ");
	        if(strs.length<=0){
	            return 0;
	        }
	        int lastIndex = strs.length-1;
	        return strs[lastIndex].length();
	    }
}
