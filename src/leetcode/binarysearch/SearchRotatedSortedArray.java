package leetcode.binarysearch;

import java.util.Arrays;

public class SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
        if(nums.length<=0){
			return -1;
		}
		
		int minIndex = findMinIndex(nums);
//		System.out.println(minIndex);
		if(target==nums[minIndex]){
		    return minIndex;
		}
		
		if(minIndex>0){
		    int res = binarySearch(nums,0,minIndex,target);
		    if(res!=-1) return res;
		}
		
		if(minIndex<=nums.length-1){
		    int res = binarySearch(nums,minIndex+1,nums.length,target);
		    if(res!=-1) return res;
		}
		
		return -1;
    }
    
    public int binarySearch(int[] nums, int low, int high, int target){
//    	System.out.println(low+" "+high);
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid]>target){
                low = mid+1;
            } else{
                high = mid-1;
            }
            
        }
        return -1;
    }
    
    public int findMinIndex(int[] nums){
        int low = 0;
        int high = nums.length-1;
        
        while(low<high){
            int mid = (low+high)/2;
            if(mid>0&&nums[mid]<nums[mid-1]){
                return mid;
            } 
            
            if(nums[mid]>nums[low] && nums[mid]>nums[high]){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        
        
        return low;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,3,4};
    	int target = 4;
    	
		SearchRotatedSortedArray srsa = new SearchRotatedSortedArray();
		System.out.println("binay"+srsa.binarySearch(nums, 1, 3, target));
		System.out.println(srsa.search(nums, target));;
	}
}	
