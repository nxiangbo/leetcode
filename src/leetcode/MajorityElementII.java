package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result  = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int times = nums.length/3;
        for(int i=0;i<nums.length;i++){
        	Integer freq = map.get(nums[i]);
			map.put(nums[i], freq==null?1:freq+1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()>times){
				result.add(entry.getKey());
			}
			
		}
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {12,12,12,43,443,54,43,645,43};
		majorityElement(nums);
	}
}
