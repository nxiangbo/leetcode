package leetcode.search;

public class FindPeakElement {
	public static int findPeakElement(int[] nums) {
        if(nums.length<=0){
        	return -1;
        }
        
        if(nums.length==1){
        	return 0;
        }
        
//        int prev = 0;
//        int current = 1;
//        int next = 2;
        for(int i=0;i<nums.length;i++){
        	if(i==0&&nums[i+1]<nums[i]){
        		return i;
        	} else if(i==nums.length-1&&nums[i]>nums[i-1]){
        		return i;
        	} else if(nums[i]>nums[i+1]&&nums[i]>nums[i-1]){
        		return i;
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,5,62,4,5};
		System.out.println(findPeakElement(nums));
	}
}
