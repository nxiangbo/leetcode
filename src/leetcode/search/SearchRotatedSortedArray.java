package leetcode.search;

public class SearchRotatedSortedArray {
	 public int search(int[] nums, int target) {
		 if(nums.length<=0){
			 return -1;
		 }
		 
		 for (int i = 0; i < nums.length; i++) {
			if(target == nums[i]){
				return i;
			}
		}
		 
		return -1;
		 
	}
	 
	public static int binarySearch(int[] nums, int target){
		if(nums.length<=0){
			return -1;
		}
		int low = 0;
		int high = nums.length-1;
		while(low<=high){
			if(nums[low]==target){
				return low;
			}
			if(nums[high]==target){
				return high;
			}
			
			if(nums[low]!=target){
				low++;
			}
			if(nums[high] != target){
				high--;
			}
		}
		return -1;
	}
	
	public static int getMiniumIndex(int[] nums){
		if(nums.length<=0){                                                                                                                                                                                                                                                                                                                                                                                                                                   
			return -1;
		}
		int low = 0;
		int high = nums.length-1;
		int mid = low;
		while(nums[low]>=nums[high]){
			if(high-low==1){
				mid = high;
				break;
			}
			
			mid = (low+high)/2;
			if(nums[mid]>=nums[low]){
				low = mid;
			} else if(nums[mid]<=nums[high]){
				high = mid;
			}
		}
		return mid;
	}
	
//	public static int binarySearch2(int[] nums, int target){
//		int minValueIndex = getMiniumIndex(nums);
//		int low = 0;
//		int high = nums.length-1;
//		
//		while(low<high){
//			
//		}
//	}
	
//	public static int binarySearchNormal(int[] nums, int target){
//		
//	}
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(binarySearch(nums, target));
		System.out.println(getMiniumIndex(nums));
	}
}
