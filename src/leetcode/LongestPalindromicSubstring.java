package leetcode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        String res = "";
        int currlen = 0;
        for(int i=0;i<s.length();i++){
            if(isPalindromic(s,i-currlen-1,i)){
                res = s.substring(i-currlen-1,i+1);
                currlen = currlen+2;
            } else if(isPalindromic(s,i-currlen,i)){
                res = s.substring(i-currlen,i+1);
                currlen = currlen+1;
            }
        }
        
        return res;
    }
    
    public boolean isPalindromic(String s, int low, int high){
        if(low<0) return false;
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
		
	}
}
