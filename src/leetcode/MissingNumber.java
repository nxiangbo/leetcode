package leetcode;

public class MissingNumber {
	public int missingNumber(int[] nums) {
        // int sum = 0;
        
        int missing = 0;
        int i = 0;
        for(i=0; i<nums.length;i++){
            missing = missing^nums[i]^i;
        }
         return missing^i;
    }
}
