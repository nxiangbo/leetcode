package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
	 public List<String> findRepeatedDnaSequences(String s) {
	        
	        HashSet<String> set = new HashSet<>();
	        HashMap<String,Integer> map = new HashMap<>();
	        for(int i=10;i<=s.length();i++){
	            String str = s.substring(i-10,i);
	            Integer freq = map.get(str);
	            if(freq==null){
	                map.put(str,1);
	            } else{
	                set.add(str);
	            }
	        }
	        
	        return new ArrayList<>(set);
	    }
}
