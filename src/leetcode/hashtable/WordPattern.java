package leetcode.hashtable;

import java.util.HashMap;

public class WordPattern {
	  public boolean wordPattern(String pattern, String str) {
	        String[] strs = str.split(" ");
	        HashMap<Character,String> map = new HashMap<>();
	        if(strs.length!=pattern.length())  return false;
	        for(int i=0;i<pattern.length();i++){
	            if(map.get(pattern.charAt(i))==null && !map.containsValue(strs[i])){
	                // System.out.println(strs[i]);
	                map.put(pattern.charAt(i),strs[i]);
	            } else if(map.get(pattern.charAt(i))!=null){
	                if(!map.get(pattern.charAt(i)).equals(strs[i])){
	                    // System.out.println(map.get(pattern.charAt(i))+" "+strs[i]);
	                    return false;
	                }
	            } else if(map.get(pattern.charAt(i))==null  && map.containsValue(strs[i])){
	                return false;
	            }
	            
	        }
	        
	        return true;
	    }
}
