package leetcode;

import java.util.Arrays;

public class RemoveElement {
	public static int removeElement(int[] nums, int val){
		
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length-1;
		while(i<j){
			while(i<j && val!=nums[i]) i++;
			while(i<j && val!=nums[j]) j--;
//			System.out.println(i  +"  "+j);
			if(nums[i]==val&&nums[j]==val){
				
				break;
			}
		}
		
		if(nums[i]==val&&nums[j]==val){
			for (int k = j+1; k <nums.length; k++) {
				nums[k-i] = nums[k];
			}
		}
		if(j == i&&nums[i]!=val){
			return nums.length;
		}
		for (int num : nums) {
			System.out.print(num+",");
		}
		System.out.println();
		return nums.length-(j-i+1);
	}
	
	public static int removeEle(int[] nums, int val){
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if(nums[j]!=val){
				nums[i] = nums[j];
				i++;
			}
		}
		for (int num : nums) {
			System.out.print(num+",");
		}
		System.out.println();
		return i;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,2,3,2,3};
		int val = 2;
		System.out.println(removeEle(nums, val));
	}
}
