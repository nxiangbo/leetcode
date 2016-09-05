package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length<=0){
            return result;
        }
        
        List<Integer> index = new ArrayList<>();
        int i =0;
        for(i=0;i<strs.length-1;i++){
            while(i<strs.length-1&&index.contains(i)) i++;
            
            List<String> each = new ArrayList<>();
            each.add(strs[i]);
            index.add(i);
            for(int j=i+1;j<strs.length;j++){
                if(isAnagram(strs[i],strs[j]) && !each.contains(strs[j])){
                    each.add(strs[j]);
                    index.add(j);
                }
            }
            result.add(each);
        }
        return result;
    }
    
    public static boolean isAnagram(String str1, String str2){
        
        int[] alphabet = new int[26];
        for(int i=0;i<str1.length();i++){
            alphabet[str1.charAt(i)-'a']++;
        }
        
        for(int j=0;j<str2.length();j++){
            alphabet[str2.charAt(j)-'a']--;
        }
        
        for(int i=0;i<alphabet.length;i++){
            if(alphabet[i]!=0){
                return false;
            }
        }
        return true;
    }
    
	public static  List<List<String>> groupAnagramsII(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length<=0){
            return result;
        }
        
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(String str:strs){
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
            
    }
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagramsII(strs);
		
		for (List<String> list : result) {

			System.out.println(list.toString());
		}
	}
    
}
