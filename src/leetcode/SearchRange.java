package leetcode;

public class SearchRange {
	 public int[] searchRange(int[] nums, int target) {
	        
	        int[] result = {-1,-1};
	        if(nums.length==1&&nums[0]==target){
	            result[0] = 0;
	            result[1] = 0;
	            return result;
	        } 
	        int low = 0;
	        int high = nums.length-1;
	        
	        while(low<=high){
	            int mid = (low+high)/2;
	            System.out.println(mid);
	            
	            if(nums[mid]==target){
	                int left = mid;
	                int right = mid;
	                while(left>0&&nums[left-1]==target){
	                    left--;
	                }
	                while(right<nums.length-1&&nums[right+1]==target){
	                    right++;
	                }
	                result[0]=left;
	                result[1] = right;
	                break;
	            }else if(nums[mid]>target){
	                high = mid-1;
	            } else{
	                low = mid+1;
	            }
	            
	        }
	        return result;
	    }
}
