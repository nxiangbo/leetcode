package leetcode;

import java.util.Random;

/**
 * 求解數組中超过元素个数一半的数字
 * @author nxiangbo
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		int appears = 1;
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (appears == 0) {
				result = nums[i];
				appears = 1;
			} else if (nums[i] == result) {
				appears++;

			} else {
				appears--;
			}

		}
		return result;
	}
	
	/**
	 * 出现次数超过一半的数字切实就是其中位数
	 * @param nums
	 * @return
	 */
	public static  int majorityElement2(int[] nums) {
		int mid = nums.length/2;
		return findKthElement(nums, mid);
		
	}
	
	public static int findKthElement(int[] nums,int k){
		Random rand = new Random();
		shuffle(nums, rand);
		int low = 0;
		int high = nums.length-1;
		while(low<high){
			int j  = partition(nums, low, high);
			if(j<k){
				low = j+1;
			} else if(j>k){
				high = j-1;
			} else{
				break;
			}
		}
		return nums[k];
	}
	
	public static int partition(int[] nums, int low, int high){
		int i = low;
		int j = high+1;
		while(true){
			while(i<high && nums[++i]< nums[low]);
			while(j>low && nums[low]< nums[--j]);
			if(i>=j){
				break;
			}
			swap(nums, i, j);
		}
		
		swap(nums, low, j);
		return j;
	}
	
	public static void shuffle(int[] nums, Random rand){
		for (int i = nums.length; i >1; i--) {
			swap(nums, i-1, rand.nextInt(i));
		}
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,3,3,3,3};
		System.out.println(majorityElement2(nums));
	}
	
	
}
