package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
	
	刚开始用的是暴力解法，要运行64ms，真是不能忍啊
	此题目可以应用HashTable
 * @author nxiangbo
 *
 */
public class TwoSum {
	@SuppressWarnings("null")
	public static int[] twoSum(int[] nums, int target) {
		int result[] = {0,0};
        if(nums.length >= 2){
        	for (int i = 0; i < nums.length-1; i++) {
				for (int j = i+1; j < nums.length; j++) {
					if(nums[i]+nums[j]==target){
						result[0] = i;
						result[1] = j;
					}
				}
			}
        	
        }
        return result;
    }
	
	public static int[] twoSumByHash(int[] nums, int target){
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i])){
				result[1] = i;
				result[0] = map.get(target-nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	} 
	
	public static void main(String[] args) {
		int[] nums ={2,4,7,11,15};
//		int target = 9;
//		int[] nums = {-1,21,32,11,-6,-3,12,-2};
		int target = 9;
		System.out.println(twoSumByHash(nums, target));
	}
}
