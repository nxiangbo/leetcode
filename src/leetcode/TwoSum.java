package leetcode;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
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
	
	public static void main(String[] args) {
//		int[] nums ={2,7,11,15};
//		int target = 9;
		int[] nums = {-1,21,32,11,-6,-3,12,-2};
		int target = 9;
//		int[] nums = {2};
//		int target = 3;
		
		int result[] = null;
		result = twoSum(nums,target);
		if(result.length>=1){
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
		}else{
			System.out.println("result=null");
		}
	}
}
