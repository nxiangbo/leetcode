package leetcode.hashtable;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        
        int ls = 0;
        int count =0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            
            map.put(s.charAt(i),i);
            ls = Math.max(ls,i-j+1);
        }
        
        return ls;
    }
}
