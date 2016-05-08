package leetcode;

public class MoveZeros {
	 public void moveZeroes(int[] nums) {
	        int count=0;
	        for(int i = nums.length-1;i>=0;i--){
	            if(nums[i]==0){
	                count++;
	            }
	        }
	        // int index = 0;
	        for(int j = 0,index=j;j<nums.length-count;j++){
	            while(nums[index]==0){
	                index++;
	            } 
	            nums[j] = nums[index];
	            index++;
	        }
	        for(int k = nums.length-count;k<nums.length;k++){
	            nums[k] = 0;
	        }
	    }
}
