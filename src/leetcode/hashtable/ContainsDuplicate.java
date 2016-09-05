package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ContainsDuplicate {
	public static boolean containsDupliacate(int[] nums){
		if(nums.length<=0){
			return false;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int freq = 0;
		for (int i : nums) {
			if(map.get(i)==null){
				map.put(i, freq);
			} else{
				freq++;
				map.put(i, freq);
			}
			if(freq>=1){
				return true;
			} 
		}
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey());
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {12,23};
		System.out.println(containsDupliacate(nums));
	}
}
