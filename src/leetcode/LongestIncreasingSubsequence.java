package leetcode;

public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}

		int[] res = new int[nums.length];
		int lis =-1;
		int maxIndex =0;
		for (int i = 0; i < nums.length; i++) {
			res[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && res[i] < res[j] + 1) {
					res[i] = res[j] + 1;
				}
			}
			if (res[i] > lis) {
				lis = res[i];
				maxIndex = i;
			}
		}
//		System.o ut.println(maxIndex);
		print(nums,lis,maxIndex,res);
		
		return lis;
	}
	
	public static void print(int[] nums, int maxLen, int maxIndex, int[] res){
		int max = maxLen;
		int index = maxIndex;
		for(int i=index;i>=0;i--){
			if(max==res[i]){
				System.out.println(nums[i]);
				max--;
			}
		}
	}
	
//	public int 
	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[] nums1 = { 1 };
		System.out.println(lengthOfLIS(nums));
	}
}
