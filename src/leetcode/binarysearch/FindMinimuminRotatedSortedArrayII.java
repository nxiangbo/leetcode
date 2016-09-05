package leetcode.binarysearch;

public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] nums) {
        int len = nums.length;
        if(len<=0){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        int low = 0;
        int high = len-1;
        while(low<=high){
            
            while(low<high&&nums[low]==nums[low+1]) low++;
            while(low<high && nums[high]==nums[high-1]) high--;
            int mid = (low+high)/2;
            if(mid>0&&nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            
            if(nums[mid]>=nums[low]&&nums[mid]>nums[high]){
                low = mid+1;
            }  else{
                high = mid-1;
            }
        }
        return nums[low];
    }
}	
